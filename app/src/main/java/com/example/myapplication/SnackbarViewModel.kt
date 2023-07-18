package com.example.myapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SnackbarViewModel: ViewModel() {
    val _shouldShow = MutableStateFlow(false)

    val shouldShow: Flow<Boolean>
        get() = _shouldShow

    fun toggleShouldShow(newValue: Boolean) {
        viewModelScope.launch {
            _shouldShow.emit(newValue)
        }
    }
}
