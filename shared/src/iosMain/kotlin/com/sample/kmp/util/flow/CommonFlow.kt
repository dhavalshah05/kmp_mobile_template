package com.sample.kmp.util.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

actual open class CommonFlow<T> actual constructor(
    private val flow: Flow<T>
): Flow<T> by flow {

    @OptIn(DelicateCoroutinesApi::class)
    fun subscribe(onCollect: (T) -> Unit): DisposableHandle {
        val job = GlobalScope.launch(Dispatchers.Main.immediate) {
            flow.collectLatest(onCollect)
        }

        return DisposableHandle { job.cancel() }
    }

}
