package com.sample.kmp.util.flow

import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow

actual class CommonStateFlow<T> actual constructor(
    private val flow: StateFlow<T>
): CommonFlow<T>(flow), StateFlow<T> by flow {

    override val replayCache: List<T>
        get() = flow.replayCache

    override val value: T
        get() = flow.value

    override suspend fun collect(collector: FlowCollector<T>): Nothing {
        flow.collect(collector)
    }

}
