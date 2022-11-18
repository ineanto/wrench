package xyz.atnrch.wrench.watcher

import xyz.atnrch.wrench.logger.Logger
import java.io.File

class WatcherManager(private val entries: MutableList<WatcherEntry>) {
    fun addFile(file: File) {
        val watcherEntry = WatcherEntry(file, arrayListOf())
        entries.add(watcherEntry)
        Logger.info("Tracking new file: ${file.name} (${file.absolutePath})")
    }

    fun getEntries(): MutableList<WatcherEntry> {
        return entries
    }
}