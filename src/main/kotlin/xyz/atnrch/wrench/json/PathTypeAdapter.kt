package xyz.atnrch.wrench.json

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.nio.file.Path
import java.nio.file.Paths

class PathTypeAdapter : TypeAdapter<Path>() {
    override fun write(out: JsonWriter?, value: Path?) {
        if (out == null) return
        out.beginObject()
        out.name("path")
        out.value(value.toString())
        out.endObject()
    }

    override fun read(`in`: JsonReader?): Path? {
        if (`in` == null) return null
        `in`.beginObject()
        val path = Paths.get(`in`.nextString())
        `in`.endObject()
        return path
    }
}
