package xyz.atnrch.wrench.io

import java.io.File

class IOManager {
    private val paths: List<IOPath>

    init {
        paths = arrayListOf()
    }

    fun addFile(file: File) {
        val path = IOPath(file, arrayListOf())
    }
}