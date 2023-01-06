package xyz.atnrch.wrench.components

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import xyz.atnrch.wrench.components.filemanager.bottom.FloatingButton
import xyz.atnrch.wrench.components.filemanager.top.TopBar
import xyz.atnrch.wrench.compose.SnackBarDataHolder
import xyz.atnrch.wrench.ui.UIColors
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
    val tabTitles = listOf("File Manager", "Servers")

    var currentClick by remember { mutableStateOf(-1) }
    var tabIndex by remember { mutableStateOf(0) }
    var minMode by remember { mutableStateOf(false) }

    minMode = state.size.width <= 600.dp
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar() },
        floatingActionButton = { if (tabIndex == 0) FloatingButton(watcherManager) },
        isFloatingActionButtonDocked = true,
        backgroundColor = UIColors.PRIMARY,
        bottomBar = {
            if (tabIndex == 0) AppBottomBar(
                minMode,
                watcherManager,
                watcher,
                currentClick,
                outputs
            ) { currentClick = it }
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