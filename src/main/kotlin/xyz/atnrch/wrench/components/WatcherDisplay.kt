package xyz.atnrch.wrench.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.components.center.empty.DefaultDisplay
import xyz.atnrch.wrench.components.center.input.InputEntries
import xyz.atnrch.wrench.components.center.output.OutputEntries
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun WatcherDisplay(
    watcherManager: WatcherManager,
    currentClick: Int,
    outputs: MutableList<Path>,
    onEntryClick: (id: Int) -> Unit
) {

    Row(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 55.dp)
    ) {
        if (watcherManager.getEntries().isEmpty()) {
            //watcherManager.addFile(File("/home/aro/IdeaProjects/Wrench/dummy"))
            DefaultDisplay()
        } else {
            InputEntries(watcherManager, onEntryClick)
            OutputEntries(watcherManager, currentClick, outputs)
        }
    }
}
