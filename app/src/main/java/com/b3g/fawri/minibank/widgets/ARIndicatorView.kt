package com.b3g.fawri.minibank.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView

class ARIndicatorView(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) : IndicatorView(context, attrs, defStyle) {

    private var recyclerView: RecyclerView? = null
    private var viewPager: ViewPager? = null
    private var selectedPosition = 0
    private var isScrubbing = false

    init {
        // Initialize the view
    }

    fun attachTo(recyclerView: RecyclerView, shouldPage: Boolean) {
        this.recyclerView = recyclerView
        addIndicators(recyclerView)
        if (shouldPage) {
            PagerSnapHelper().attachToRecyclerView(recyclerView)
        }
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (recyclerView.scrollState == RecyclerView.SCROLL_STATE_SETTLING) {
                    if (recyclerView.layoutManager is LinearLayoutManager) {
                        val position = if (dx > 0) {
                            (recyclerView.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
                        } else {
                            (recyclerView.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                        }
                        if (position <= indicators.size - 1 && selectedPosition != position) {
                            selectIndicatorAt(position)
                            if (indicatorAnimation != 0) {
                                animateIndicator(position)
                            }
                        }
                    }
                }
            }
        })
    }

    fun attachTo(viewPager: ViewPager) {
        this.viewPager = viewPager
        addIndicators(viewPager)
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                selectIndicatorAt(position)
                if (indicatorAnimation != 0) {
                    animateIndicator(position)
                }
            }
            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    private fun addIndicators(recyclerView: RecyclerView) {
        recyclerView.adapter?.let { adapter ->
            for (i in 0 until adapter.itemCount) {
                drawCircle(i)
            }
        } ?: throw NullPointerException("RecyclerView Adapter not found or null --> ARIndicatorView")
    }

    private fun addIndicators(viewPager: ViewPager) {
        viewPager.adapter?.let { pagerAdapter ->
            for (i in 0 until pagerAdapter.count) {
                drawCircle(i)
            }
        } ?: throw NullPointerException("ViewPager Adapter is null --> ARIndicatorView")
    }

    private fun unSelectIndicators() {
        indicators.forEach { imageView ->
            setUnActiveColorTo(imageView)
        }
    }

    private fun invalidateIndicators() {
        removeIndicators()
        recyclerView?.let { addIndicators(it) } ?: viewPager?.let { addIndicators(it) }
        selectIndicatorAt(selectedPosition)
    }

    private fun selectIndicatorAt(position: Int) {
        selectedPosition = position
        unSelectIndicators()
        setActiveColorTo(indicators[selectedPosition])
    }

    private fun removeIndicators() {
        indicators.forEach { imageView ->
            removeView(imageView)
        }
        indicators.clear()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (ev?.action == MotionEvent.ACTION_DOWN) {
            return isScrubbingEnabled
        }
        ev?.let { selectIndicatorWhenScrubbing(it) }
        return isScrubbingEnabled
    }

    private fun selectIndicatorWhenScrubbing(ev: MotionEvent) {
        val x = ev.x.toInt()
        val y = ev.y.toInt()
        for (i in 0 until childCount) {
            val child = getChildAt(i) as? ImageView
            if (x > child?.left ?: 0 && x < child?.right ?: 0 && y > child?.top ?: 0 && y < child?.bottom ?: 0) {
                isScrubbing = true
                selectIndicatorAt(i)
                scrollToPosition(i)
            }
        }
    }

    private fun scrollToPosition(position: Int) {
        recyclerView?.smoothScrollToPosition(position) ?: viewPager?.setCurrentItem(position, true)
    }

    private fun animateIndicator(position: Int) {
        if (isScrubbingEnabled && isScrubbing && shouldAnimateOnScrubbing) {
            indicators[position].startAnimation(AnimationUtils.loadAnimation(context, indicatorAnimation))
        } else {
            indicators[position].startAnimation(AnimationUtils.loadAnimation(context, indicatorAnimation))
        }
    }
}
