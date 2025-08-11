package com.mapp

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.asStateFlow

data class NamesAndColor(
    val name1:String = "A",
    val name2:String = "B",
    val name3:String = "C",
    val color: Color = Color(0x00ff00ff)
)

class ReactiveViewModel : ViewModel() {
    private val _state = kotlinx.coroutines.flow.MutableStateFlow(NamesAndColor())
    val state = _state.asStateFlow()
    private val names = listOf("Harold","Darren","Jean","François","Eloise","Kean","Patrick","Teo","Yan","Alice","Tiago","A","B","C")
    private val colors = listOf(Color(0xFFFFFFFF), Color(0x9C27B0FF), Color(0x2196F3FF), Color(0x4CAF50FF), Color(0x00BCD4FF), Color(0xFFC107FF))

    fun onClick() {
        _state.value = NamesAndColor(
            name1 = names.random(),
            name2 = names.random(),
            name3 = names.random(),
            color = colors.random()
        )
    }
}