package xyz.atnrch.wrench.components.filemanager

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.window.WindowState
import xyz.atnrch.wrench.components.filemanager.bottom.BottomAppBar
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
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val entries: MutableMap<Int, WatcherEntry> = remember { mutableStateMapOf() }
    val outputs: MutableList<Path> = remember { mutableStateListOf() }
    val snackBarDataHolder = SnackBarDataHolder(scaffoldState, rememberCoroutineScope())
    val watcherManager = remember { WatcherManager(entries) }
    val watcher = remember { Watcher(watcherManager, snackBarDataHolder) }
    var currentClick by remember { mutableStateOf(-1) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar() },
        floatingActionButton = { FloatingButton(watcherManager) },
        isFloatingActionButtonDocked = true,
        backgroundColor = UIColors.PRIMARY,
        bottomBar = { BottomAppBar(state, watcherManager, watcher, currentClick, outputs) { currentClick = it } }
    ) { WatcherDisplay(state, watcherManager, currentClick, outputs) { currentClick = it } }
}