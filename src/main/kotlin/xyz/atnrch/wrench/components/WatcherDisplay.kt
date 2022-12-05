package xyz.atnrch.wrench.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import xyz.atnrch.wrench.components.center.empty.DefaultDisplay
import xyz.atnrch.wrench.components.center.input.InputEntries
import xyz.atnrch.wrench.components.center.output.OutputEntries
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun WatcherDisplay(
    state: WindowState,
    watcherManager: WatcherManager,
    currentClick: Int,
    outputs: MutableList<Path>,
    onEntryClick: (id: Int) -> Unit
) {
    if (state.size.width <= 600.dp) {
        Column(
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 55.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            displayEntries(true, watcherManager, currentClick, outputs, onEntryClick)
        }
    } else {
        Row(
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 55.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            displayEntries(false, watcherManager, currentClick, outputs, onEntryClick)
        }
    }
}

@Composable
fun displayEntries(
    minmode: Boolean,
    watcherManager: WatcherManager,
    currentClick: Int,
    outputs: MutableList<Path>,
    onEntryClick: (id: Int) -> Unit
) {
    if (watcherManager.getEntries().isEmpty()) {
        //watcherManager.addFile(File("/home/aro/IdeaProjects/Wrench/dummy"))
        DefaultDisplay()
    } else {
        InputEntries(minmode, watcherManager, onEntryClick)
        OutputEntries(minmode, watcherManager, currentClick, outputs)
    }
}
