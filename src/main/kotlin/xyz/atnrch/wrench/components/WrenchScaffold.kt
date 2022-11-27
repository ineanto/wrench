package xyz.atnrch.wrench.components

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import xyz.atnrch.wrench.components.bottom.BottomAppBar
import xyz.atnrch.wrench.components.bottom.FloatingButton
import xyz.atnrch.wrench.components.top.TopBar
import xyz.atnrch.wrench.compose.SnackBarDataHolder
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun WrenchScaffold() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val entries: MutableMap<Int, WatcherEntry> = remember { mutableStateMapOf() }
    val snackBarDataHolder = SnackBarDataHolder(scaffoldState, rememberCoroutineScope())
    val watcherManager = remember { WatcherManager(entries) }
    val watcher = remember { Watcher(watcherManager, snackBarDataHolder) }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { TopBar() },
        floatingActionButton = { FloatingButton(watcherManager) },
        isFloatingActionButtonDocked = true,
        bottomBar = { BottomAppBar(watcher) }
    ) { WatcherDisplay(watcherManager) }
}