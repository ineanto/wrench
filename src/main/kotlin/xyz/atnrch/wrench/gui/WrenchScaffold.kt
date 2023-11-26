package xyz.atnrch.wrench.gui

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import xyz.atnrch.wrench.gui.appearance.UIColors
import xyz.atnrch.wrench.gui.component.SnackBarDataHolder
import xyz.atnrch.wrench.gui.filemanager.bottom.FileAppBottomBar
import xyz.atnrch.wrench.gui.filemanager.bottom.FileManagerAddButton
import xyz.atnrch.wrench.gui.server.bottom.ServerAppBottomBar
import xyz.atnrch.wrench.storage.LayoutStorage
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun WrenchScaffold(state: WindowState) {
    // i love god objects
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val entries: MutableMap<Int, WatcherEntry> = remember { mutableStateMapOf() }
    val outputs: MutableList<Path> = remember { mutableStateListOf() }
    val snackBarDataHolder = SnackBarDataHolder(scaffoldState, rememberCoroutineScope())
    val watcherManager = remember { WatcherManager(entries) }
    val watcher = remember { Watcher(watcherManager, snackBarDataHolder) }
    val tabTitles = listOf("Files", "Servers")
    val layoutStorage = LayoutStorage {
        it.forEach { entry ->
            watcherManager.addFile(entry.file, entry.outputs)
        }
    }

    var currentClick by remember { mutableStateOf(-1) }
    var tabIndex by remember { mutableStateOf(0) }
    var minMode by remember { mutableStateOf(false) }

    minMode = state.size.width <= 600.dp
    if (state.size.width < 500.dp) {
        Text("Window is too small")
    } else {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = { TopBar(layoutStorage, tabIndex, entries.values) },
            floatingActionButton = { if (tabIndex == 0) FileManagerAddButton(watcherManager) },
            isFloatingActionButtonDocked = true,
            backgroundColor = UIColors.PRIMARY,
            bottomBar = {
                if (tabIndex == 0) FileAppBottomBar(
                    minMode,
                    watcherManager,
                    watcher,
                    currentClick,
                    outputs
                ) { currentClick = it }
                else {
                    ServerAppBottomBar(minMode, currentClick) { currentClick = it }
                }
            }
        ) {
            WatcherDisplay(
                minMode,
                watcherManager,
                currentClick,
                outputs,
                { currentClick = it },
                tabIndex,
                tabTitles
            ) { tabIndex = it }
        }
    }
}