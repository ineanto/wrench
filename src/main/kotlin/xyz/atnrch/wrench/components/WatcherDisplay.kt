package xyz.atnrch.wrench.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import xyz.atnrch.wrench.components.center.input.InputEntries
import xyz.atnrch.wrench.components.center.output.OutputEntries
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun WatcherDisplay(
    watcherManager: WatcherManager
) {
    Row {
        if(watcherManager.getEntries().isEmpty()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            ) {
                Text("Add a file to start...")
            }
        } else {
            InputEntries(watcherManager)
            OutputEntries(watcherManager)
        }
    }
}
