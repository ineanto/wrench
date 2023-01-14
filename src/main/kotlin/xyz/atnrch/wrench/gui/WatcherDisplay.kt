package xyz.atnrch.wrench.gui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import xyz.atnrch.wrench.gui.filemanager.FileManagerDisplay
import xyz.atnrch.wrench.gui.server.ServerManagerDisplay
import xyz.atnrch.wrench.gui.appearance.UIColors
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun WatcherDisplay(
    minMode: Boolean,
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
            0 -> FileManagerDisplay(minMode, watcherManager, currentClick, outputs, onEntryClick)
            1 -> ServerManagerDisplay()
        }
    }
}
