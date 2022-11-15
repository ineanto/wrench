package xyz.atnrch.wrench.watcher

import xyz.atnrch.wrench.logger.Logger
import java.io.File

class WatcherManager {
    private val entries: ArrayList<WatcherEntry> = arrayListOf()

    fun addFile(file: File) {
        val watcherEntry = WatcherEntry(file, arrayListOf())
        entries.add(watcherEntry)
        Logger.info("Traking new file: ${file.name} (${file.absolutePath})")
    }

    fun getEntries(): ArrayList<WatcherEntry> {
        return entries
    }
}