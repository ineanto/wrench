package xyz.atnrch.wrench.components.filemanager

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    onEntryClick: (id: Int) -> Unit,
    tabIndex: Int,
    tabTitles: List<String>,
    onTabChange: (id: Int) -> Unit
) {

    Column {
        TabRow(
            selectedTabIndex = tabIndex,
            backgroundColor = UIColors.ORANGE,
            contentColor = Color.White
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(selected = tabIndex == index,
                    onClick = { onTabChange(index) },
                    text = { Text(text = title) })
            }
        }
        when (tabIndex) {
            0 -> FileManagerDisplay(state, watcherManager, currentClick, outputs, onEntryClick)
            1 -> TODO("Add Server Manager")
        }
    }
}

@Composable
fun FileManagerDisplay(
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
fun DisplayEntries(
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
