package xyz.atnrch.wrench.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.components.debug.DummyTextEntry
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun WatcherDisplay(
    watcherManager: WatcherManager
) {
    var selectedFile = remember { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(PaddingValues(0.dp, 0.dp, 0.dp, 55.dp))
                .fillMaxHeight()
                .fillMaxWidth(0.5f)
                .border(BorderStroke(4.dp, UIColors.ORANGE), RectangleShape)
        ) {
            Column {
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
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(PaddingValues(0.dp, 0.dp, 0.dp, 55.dp))
                .fillMaxHeight()
                .fillMaxWidth(1f)
                .border(BorderStroke(4.dp, UIColors.STRESS), RectangleShape)
        ) {
            Column {
                //.............
                // OUTPUT SIDE
                //.............
                DummyTextEntry()
            }
        }
    }
}
