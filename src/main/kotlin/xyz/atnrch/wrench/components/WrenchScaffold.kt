package xyz.atnrch.wrench.components

import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import xyz.atnrch.wrench.watcher.Watcher

@Composable
fun WrenchScaffold() {
    val watcher = remember { Watcher() }
    var state by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { AddButton() },
        isFloatingActionButtonDocked = true,
        bottomBar = { BottomAppBar(watcher, state) { state = it } }
    ) {
        WrenchFileManagerInput()
        WrenchFileManagerOutput()
    }

}