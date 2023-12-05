package com.sample.kmp.util.viewModel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancelChildren

abstract class BaseViewModel(
    scope: CoroutineScope?
) {
    protected val viewModelScope = scope ?: CoroutineScope(Dispatchers.Main.immediate)

    fun onCleared() {
        viewModelScope.coroutineContext.cancelChildren()
    }
}
