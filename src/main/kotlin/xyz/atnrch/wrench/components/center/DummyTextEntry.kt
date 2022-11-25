package xyz.atnrch.wrench.components.debug

import androidx.compose.runtime.Composable
import xyz.atnrch.wrench.components.WatcherTextEntry
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager
import java.io.File

@Composable
fun DummyTextEntry(watcherManager: WatcherManager) {
    WatcherTextEntry(0, WatcherEntry(File("/home/aro/IdeaProjects/Wrench/dummy"), arrayListOf()), watcherManager)
}