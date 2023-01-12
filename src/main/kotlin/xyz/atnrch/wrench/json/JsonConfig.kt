package xyz.atnrch.wrench.json

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import xyz.atnrch.wrench.watcher.WatcherEntry
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.nio.file.Path

class JsonConfig(
    private val onWatcherEntriesUpdate: (List<WatcherEntry>) -> Unit
) {
    private val watcherEntryListType = object : TypeToken<List<WatcherEntry>>() {}.type
    private val watcherEntryType = object : TypeToken<WatcherEntry>() {}.type
    private val gson: Gson = Gson().newBuilder()
        .registerTypeAdapter(watcherEntryType, WatcherEntryAdapter())
        .registerTypeAdapter(Path::class.java, PathTypeAdapter())
        .setPrettyPrinting()
        .create()
    private val file = File("layout.json")

    fun writeLayout(list: List<WatcherEntry>) {
        val writer = FileWriter(file)
        gson.toJson(list, writer)
        writer.flush()
        writer.close()
    }

    fun readLayout() {
        val reader = FileReader(file)
        val entries = gson.fromJson<List<WatcherEntry>>(reader, watcherEntryListType)
        reader.close()
        onWatcherEntriesUpdate.invoke(entries)
    }
}