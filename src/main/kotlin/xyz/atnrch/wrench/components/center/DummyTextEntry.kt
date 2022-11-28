package xyz.atnrch.wrench.components.center

import androidx.compose.runtime.Composable
import xyz.atnrch.wrench.components.center.input.InputTextEntry
import xyz.atnrch.wrench.registery.RegisterComposable
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager
import java.io.File

@Composable
fun DummyTextEntry(
    watcherManager: WatcherManager,
    onEntrySelected: (id: Int) -> Unit
) {
    val id = 0
    RegisterComposable(id) {
        InputTextEntry(
            id,
            WatcherEntry(File("/home/aro/IdeaProjects/Wrench/dummy"), arrayListOf()),
            onEntrySelected
        )
    }
}