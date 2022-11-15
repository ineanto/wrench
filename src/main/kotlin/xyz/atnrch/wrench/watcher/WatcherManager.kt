package xyz.atnrch.wrench.watcher

import xyz.atnrch.wrench.logger.Logger
import java.io.File

class WatcherManager {
    private val entries: List<WatcherEntry>

    init {
        entries = arrayListOf()
    }

    fun addFile(file: File) {
        val watcherEntry = WatcherEntry(file, arrayListOf())
        Logger.info("Traking new file: ${file.name} (${file.absolutePath})")
    }
}