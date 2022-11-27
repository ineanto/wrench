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
import xyz.atnrch.wrench.components.center.showDirectoryPicker
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager
import kotlin.io.path.pathString

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
                        Column(
                            verticalArrangement = Arrangement.SpaceEvenly,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            if (entry.map.isEmpty()) {
                                Text("No output")
                            } else {
                                entry.map.forEach {
                                    Text(it.pathString)
                                }
                            }
                            Spacer(Modifier.height(28.dp))
                            Button(
                                onClick = {
                                    showDirectoryPicker({
                                        Logger.info("Path: ${it.absolutePath}")
                                        entry.map.add(it.toPath())
                                    }, {
                                        Logger.info("No file selected.")
                                    })
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