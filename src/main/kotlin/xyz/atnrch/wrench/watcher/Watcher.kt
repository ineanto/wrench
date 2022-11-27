package xyz.atnrch.wrench.watcher

import kotlinx.coroutines.*
import kotlinx.coroutines.swing.Swing
import xyz.atnrch.wrench.logger.Logger
import java.util.concurrent.TimeUnit

class Watcher(private val watcherManager: WatcherManager) {
    companion object {
        var WATCHING = false
    }

    private var coroutineScope = CoroutineScope(Dispatchers.Swing)

    fun start() {
        if (WATCHING) return

        coroutineScope.launch {
            WATCHING = true
            Logger.info("Started Watcher.")
            while (WATCHING) {
                delay(TimeUnit.SECONDS.toMillis(5))
                for (entry: WatcherEntry in watcherManager.getEntries().values) {
                    entry.map.forEach {
                        //Files.copy(entry.file.toPath(), it.toAbsolutePath())
                    }
                }
            }
        }
    }

    fun stop() {
        Logger.info("Stopped Watcher.")
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        WATCHING = false
    }
}