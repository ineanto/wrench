package xyz.atnrch.wrench.components.center.output

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PostAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun OutputEntries(
    watcherManager: WatcherManager,
    currentSelectedInputId: Int
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .padding(PaddingValues(0.dp, 0.dp, 0.dp, 55.dp))
            .fillMaxHeight()
            .fillMaxWidth()
            .border(BorderStroke(4.dp, UIColors.STRESS), RectangleShape)
    ) {
        OutputTopText()
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            val entry: WatcherEntry? = watcherManager.getFromId(currentSelectedInputId)
            if (entry != null) {
                if (entry.map.isEmpty()) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Column (
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("No output")
                            Spacer(Modifier.height(28.dp))
                            Text("CURRENT SELECTED FILE IS: ${entry.file.absolutePath}")
                            Spacer(Modifier.height(28.dp))
                            Button(
                                onClick = {
                                    println("test")
                                }
                            ) {
                                Icon(
                                    Icons.Filled.PostAdd,
                                    tint = Color.White,
                                    contentDescription = "Add",
                                    modifier = Modifier.size(28.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}