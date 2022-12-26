package xyz.atnrch.wrench.components.filemanager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import xyz.atnrch.wrench.components.filemanager.center.empty.DefaultDisplay
import xyz.atnrch.wrench.components.filemanager.center.input.InputEntries
import xyz.atnrch.wrench.components.filemanager.center.output.OutputEntries
import xyz.atnrch.wrench.ui.UIColors
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
    var tabIndex by remember { mutableStateOf(0) } // 1.
    val tabTitles = listOf("File Manager", "Servers")
    Column { // 2.
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = UIColors.ORANGE
        ) { // 3.
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index, // 4.
                    onClick = { tabIndex = index },
                    text = { Text(text = title) }) // 5.
            }
        }
        when (tabIndex) { // 6.
            0 -> getDisplayDependingOnSize(state, watcherManager, currentClick, outputs, onEntryClick)
            1 -> Text("There content")
        }
    }
}

@Composable
fun getDisplayDependingOnSize(
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
