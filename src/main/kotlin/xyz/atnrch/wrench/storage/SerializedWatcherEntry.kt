package xyz.atnrch.wrench.storage

import xyz.atnrch.wrench.watcher.WatcherEntry
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import kotlin.io.path.absolutePathString

data class SerializedWatcherEntry(val path: String, val outputs: ArrayList<String>) {
    companion object {
        private fun serializeEntry(entry: WatcherEntry): SerializedWatcherEntry {
            val outputs = arrayListOf<String>()
            entry.outputs.forEach {
                outputs.add(it.absolutePathString())
            }

            return SerializedWatcherEntry(entry.file.path, outputs)
        }

        private fun deserializeEntry(entry: SerializedWatcherEntry): WatcherEntry {
            val file = File(entry.path)
            val outputs = arrayListOf<Path>()

            entry.outputs.forEach { path ->
                outputs.add(Paths.get(path))
            }

            return WatcherEntry(file, outputs)
        }

        fun fromUnserializedEntries(list: List<WatcherEntry>): List<SerializedWatcherEntry> {
            val serialized = arrayListOf<SerializedWatcherEntry>()
            list.forEach {
                serialized.add(serializeEntry(it))
            }
            return serialized
        }

        fun fromSerializedEntries(list: List<SerializedWatcherEntry>): List<WatcherEntry> {
            val deserialized = arrayListOf<WatcherEntry>()
            list.forEach {
                deserialized.add(deserializeEntry(it))
            }
            return deserialized
        }
    }
}