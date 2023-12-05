package com.sample.kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform