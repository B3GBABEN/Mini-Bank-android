/*package com.b3g.fawri.minibank.keyboard

import android.content.Context
import android.widget.EditText
import com.b3g.fawri.minibank.widgets.keyboard.CustomKeyboard
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)

class CustomKeyboardTest {
   private lateinit var keyboard: CustomKeyboard
   private lateinit var editText: EditText
   @Mock
   private lateinit var contextMock: Context
   @Before
   fun setUp()
   {
      editText = EditText(contextMock)
      keyboard = CustomKeyboard()
      keyboard.setEditText(editText)
   }
   @Test
   fun testWriteShouldWriteCorrectlly()
   {
      val number=12
      keyboard.write(number)
      assertEquals(number, editText.text.toString())
   }
}*/