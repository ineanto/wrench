package xyz.atnrch.wrench.components

import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import xyz.atnrch.wrench.components.center.AddButton
import xyz.atnrch.wrench.components.top.TopBar
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun WrenchScaffold() {
    val entries: MutableMap<Int, WatcherEntry> = remember { mutableStateMapOf() }
    val watcherManager = remember { WatcherManager(entries) }
    val watcher = remember { Watcher(watcherManager) }
    var buttonState by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { AddButton(watcherManager) },
        isFloatingActionButtonDocked = true,
        bottomBar = { BottomAppBar(watcher, buttonState) { buttonState = it } }
    ) { WatcherDisplay(watcherManager) }

}