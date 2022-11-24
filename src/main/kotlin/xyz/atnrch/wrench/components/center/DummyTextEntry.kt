package xyz.atnrch.wrench.components.debug

import androidx.compose.runtime.Composable
import xyz.atnrch.wrench.components.WatcherTextEntry
import xyz.atnrch.wrench.watcher.WatcherEntry
import java.io.File

@Composable
fun DummyTextEntry() {
    WatcherTextEntry(WatcherEntry(File("/home/aro/IdeaProjects/Wrench/dummy"), arrayListOf()))
}