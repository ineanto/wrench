package xyz.atnrch.wrench.components

import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import xyz.atnrch.wrench.watcher.Watcher

@Composable
fun WrenchScaffold() {
    val watcher = remember { Watcher() }
    var buttonState by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopBar() },
        floatingActionButton = { AddButton() },
        isFloatingActionButtonDocked = true,
        bottomBar = { BottomAppBar(watcher, buttonState) { buttonState = it } }
    ) {
        WrenchFileManagerInput()
        WrenchFileManagerOutput()
    }

}