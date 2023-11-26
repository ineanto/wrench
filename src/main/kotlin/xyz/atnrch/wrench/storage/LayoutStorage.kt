package xyz.atnrch.wrench.storage

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import xyz.atnrch.wrench.Wrench
import xyz.atnrch.wrench.watcher.WatcherEntry
import java.io.File
import java.io.FileReader
import java.io.FileWriter

class LayoutStorage(private val onWatcherEntriesUpdate: (List<WatcherEntry>) -> Unit) {
    private val entryListType = object : TypeToken<List<SerializedWatcherEntry>>() {}.type
    private val gson: Gson = Gson().newBuilder()
        .setPrettyPrinting()
        .create()
    private val file = File(Wrench.ROOT_FOLDER, "${File.separator}layout.json")

    fun storeLayout(list: List<SerializedWatcherEntry>) {
        val writer = FileWriter(file)
        gson.toJson(list, writer)
        writer.flush()
        writer.close()
    }

    fun readLayout() {
        val reader = FileReader(file)
        val line = reader.readText()
        reader.close()

        val serializedEntries = gson.fromJson<List<SerializedWatcherEntry>>(line, entryListType)
        val deserializedEntries = SerializedWatcherEntry.fromSerializedEntries(serializedEntries)
        onWatcherEntriesUpdate.invoke(deserializedEntries)
    }
}