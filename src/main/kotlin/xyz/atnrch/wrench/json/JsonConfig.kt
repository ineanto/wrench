package xyz.atnrch.wrench.json

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import xyz.atnrch.wrench.watcher.WatcherEntry
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class JsonConfig {
    private val gson: Gson = Gson().newBuilder().serializeNulls().setPrettyPrinting().create()
    private val file = File("layout.json")
    private val watcherEntryType = object : TypeToken<List<WatcherEntry>>() {}.type

    fun writeLayout(list: List<WatcherEntry>) {
        gson.toJson(list, FileWriter(file))
    }

    fun readLayout() {
        gson.fromJson<List<WatcherEntry>>(FileReader(file), watcherEntryType)
    }
}