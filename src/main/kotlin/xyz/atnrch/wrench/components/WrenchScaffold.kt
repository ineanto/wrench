package xyz.atnrch.wrench.components

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import xyz.atnrch.wrench.components.center.AddButton
import xyz.atnrch.wrench.components.top.TopBar
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun WrenchScaffold() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val entries: MutableMap<Int, WatcherEntry> = remember { mutableStateMapOf() }
    val watcherManager = remember { WatcherManager(entries) }
    val watcher = remember { Watcher(watcherManager) }
    var watcherState by remember { mutableStateOf(false) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar() },
        floatingActionButton = { AddButton(watcherManager) },
        isFloatingActionButtonDocked = true,
        bottomBar = { BottomAppBar(watcher, watcherState) { watcherState = it } }
    ) { WatcherDisplay(watcherManager) }

}