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
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherManager

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WatcherDisplay(
    watcherManager: WatcherManager
) {
    var selectedFile = remember { mutableStateOf("") }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(1f)
            .border(BorderStroke(4.dp, Color.Black), RectangleShape),
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

    Box {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(1f)
                .border(BorderStroke(4.dp, UIColors.STRESS), RectangleShape),
        ) {
            Column(
                modifier = Modifier.padding(24.dp)
            ) {
                //.............
                // OUTPUT SIDE
                //.............
                DummyTextEntry()
            }
        }
    }
}
