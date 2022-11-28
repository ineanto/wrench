package xyz.atnrch.wrench.components

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import xyz.atnrch.wrench.components.bottom.BottomAppBar
import xyz.atnrch.wrench.components.bottom.FloatingButton
import xyz.atnrch.wrench.components.top.TopBar
import xyz.atnrch.wrench.compose.SnackBarDataHolder
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun WrenchScaffold() {
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
        bottomBar = { BottomAppBar(watcherManager, watcher, currentClick, outputs) }
    ) { WatcherDisplay(watcherManager, currentClick, outputs) { currentClick = it } }
}