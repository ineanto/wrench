package xyz.atnrch.wrench.gui.filemanager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.filemanager.center.EmptyFileManagerView
import xyz.atnrch.wrench.gui.filemanager.center.input.InputEntries
import xyz.atnrch.wrench.gui.filemanager.center.output.OutputEntries
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun FileManagerDisplay(
    minMode: Boolean,
    watcherManager: WatcherManager,
    currentClick: Int,
    outputs: MutableList<Path>,
    onEntryClick: (id: Int) -> Unit
) {
    if (minMode) {
        Column(
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 55.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DisplayEntries(true, watcherManager, currentClick, outputs, onEntryClick)
        }
    } else {
        Row(
            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 55.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            DisplayEntries(false, watcherManager, currentClick, outputs, onEntryClick)
        }
    }
}

@Composable
private fun DisplayEntries(
    minMode: Boolean,
    watcherManager: WatcherManager,
    currentClick: Int,
    outputs: MutableList<Path>,
    onEntryClick: (id: Int) -> Unit
) {
    if (watcherManager.getEntries().isEmpty()) {
        EmptyFileManagerView()
    } else {
        InputEntries(minMode, watcherManager, onEntryClick)
        OutputEntries(watcherManager, currentClick, outputs)
    }
}