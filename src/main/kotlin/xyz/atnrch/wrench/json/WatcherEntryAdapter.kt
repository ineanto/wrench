package xyz.atnrch.wrench.json

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.watcher.WatcherEntry
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

class WatcherEntryAdapter : TypeAdapter<WatcherEntry>() {
    override fun write(writer: JsonWriter?, value: WatcherEntry?) {
        if (writer == null) {
            Logger.warn("JsonWriter is null?")
            return
        }

        if (value == null) {
            writer.nullValue()
            return
        }

        writer.beginObject()
        writer.name("file").value(value.file.path)

        writer.name("outputs").beginArray()
        value.outputs.forEach {
            writer.beginObject()
            writer.name("path").value(it.toString())
            writer.endObject()
        }
        writer.endArray()
        writer.endObject()
    }

    override fun read(reader: JsonReader?): WatcherEntry? {
        if (reader == null) {
            Logger.warn("JsonReader is null?")
            Logger.warn("Failed to parse Layout.")
            return null
        }

        reader.beginObject()
        //val file = File(reader.nextString())
        val outputs = arrayListOf<Path>()

        reader.beginArray()
        while(reader.peek() != JsonToken.END_ARRAY) {
            while(reader.peek() != JsonToken.END_OBJECT) {
                if(reader.peek() == JsonToken.STRING) {
                    outputs.add(Paths.get(reader.nextString()))
                }
            }
        }
        reader.endArray()
        reader.endObject()
        return WatcherEntry(File("/home/aro/text"), outputs)
    }
}
