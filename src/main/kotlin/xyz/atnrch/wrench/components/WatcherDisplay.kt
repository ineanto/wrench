package xyz.atnrch.wrench.components

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import xyz.atnrch.wrench.components.center.input.InputEntries
import xyz.atnrch.wrench.components.center.output.OutputEntries
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun WatcherDisplay(
    watcherManager: WatcherManager
) {
    Row {
        InputEntries(watcherManager)
        OutputEntries()
    }
}
