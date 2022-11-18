package xyz.atnrch.wrench.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.components.debug.DummyTextEntry
import xyz.atnrch.wrench.watcher.WatcherManager

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WatcherDisplay(
    watcherManager: WatcherManager
) {
    var selectedFile = remember { mutableStateOf("") }
    Column {
        Box(
            contentAlignment = Alignment.CenterStart,
            modifier = Modifier.fillMaxSize(50F).border(BorderStroke(8.dp, Color.Black), RectangleShape),
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                //.............
                // INPUT SIDE
                //.............
                watcherManager.getEntries().forEach {
                    WatcherTextEntry(it)
                }
                DummyTextEntry()
            }
        }
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier.fillMaxSize(50F),
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                //.............
                // OUTPUT SIDE
                //.............
            }
        }
    }
}
