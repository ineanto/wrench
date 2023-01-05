package xyz.atnrch.wrench.watcher

import xyz.atnrch.wrench.logger.Logger
import java.io.File
import java.nio.file.Path

class WatcherManager(private val entries: MutableMap<Int, WatcherEntry>) {
    private var currentId: Int = -1

    fun addFile(file: File, outputs: ArrayList<Path>) {
        val watcherEntry = WatcherEntry(file, outputs)
        currentId += 1
        entries[currentId] = watcherEntry
        Logger.info(
            """
            Tracking new file:
            ID: $currentId
            Name: ${file.name}
            Path: ${file.absolutePath}
        """.trimIndent()
        )
    }

    fun addFile(file: File) {
        addFile(file, arrayListOf())
    }

    fun removeFile(id: Int) {
        entries.remove(id)
    }

    fun getEntries(): MutableMap<Int, WatcherEntry> {
        return entries
    }

    fun getFromId(id: Int): WatcherEntry? {
        if (id == -1) {
            return null
        }
        return entries[id]
    }
}