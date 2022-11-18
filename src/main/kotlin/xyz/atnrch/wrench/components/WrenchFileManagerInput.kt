package xyz.atnrch.wrench.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.watcher.WatcherManager

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WatcherDisplay(
    watcherManager: WatcherManager
) {
    var selectedFile = remember { mutableStateOf("") }

    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(84.dp)
        ) {
            //.............
            // INPUT SIDE
            //.............
            watcherManager.getEntries().forEach {
                Text(
                    text = "${it.file.absolutePath}",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = TextUnit(15F, TextUnitType.Sp)
                    )
                )
            }
        }
    }
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(84.dp)
        ) {
            //.............
            // OUTPUT SIDE
            //.............
        }
    }
}
