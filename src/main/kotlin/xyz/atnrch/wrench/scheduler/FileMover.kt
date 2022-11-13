package xyz.atnrch.wrench.scheduler

import kotlinx.coroutines.*
import kotlinx.coroutines.swing.Swing
import java.util.concurrent.TimeUnit

class FileMover {
    private var coroutineScope = CoroutineScope(Dispatchers.Swing)
    private var isActive = false

    fun start() {
        if(isActive) return

        coroutineScope.launch {
            this@FileMover.isActive = true
            while (isActive) {
                delay(TimeUnit.SECONDS.toMillis(5))
                println("Hello world!")
            }
        }
    }

    fun pause() {
        isActive = false
    }

    fun stop() {
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        isActive = false
    }
}