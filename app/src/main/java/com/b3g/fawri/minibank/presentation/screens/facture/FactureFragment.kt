package com.b3g.fawri.minibank.presentation.screens.factures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.b3g.fawri.minibank.databinding.FragmentFactureBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import androidx.fragment.app.viewModels


@AndroidEntryPoint
class FactureFragment : Fragment() {

    private var _binding: FragmentFactureBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FactureViewModel  by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFactureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factureAdapter = FactureAdapter(emptyList())
        binding.factureRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = factureAdapter
        }

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                state.factures?.let {
                    factureAdapter.updateFactures(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
