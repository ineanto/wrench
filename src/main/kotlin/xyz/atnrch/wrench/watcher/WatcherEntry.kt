package xyz.atnrch.wrench.watcher

import java.io.File
import java.nio.file.Path

data class WatcherEntry(val file: File, val map: ArrayList<Path>)
