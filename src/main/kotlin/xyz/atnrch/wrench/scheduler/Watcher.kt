package xyz.atnrch.wrench.scheduler

import kotlinx.coroutines.*
import kotlinx.coroutines.swing.Swing
import java.util.concurrent.TimeUnit

class Watcher {
    companion object {
        var WATCHING = false
    }

    private var coroutineScope = CoroutineScope(Dispatchers.Swing)

    fun start() {
        if(WATCHING) return

        coroutineScope.launch {
            WATCHING = true
            while (WATCHING) {
                delay(TimeUnit.SECONDS.toMillis(5))
                println("Hello world!")
            }
        }
    }

    fun stop() {
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        WATCHING = false
    }
}