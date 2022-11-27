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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.components.center.showDirectoryPicker
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path
import kotlin.io.path.pathString

@OptIn(ExperimentalUnitApi::class)
@Composable
fun OutputEntries(
    watcherManager: WatcherManager,
    currentSelectedInputId: Int
) {
    val outputs: MutableList<Path> = remember { mutableStateListOf() }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
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
                outputs.clear()
                outputs.addAll(entry.map)

                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        if (outputs.isEmpty()) {
                            Text(
                                text = "No outputs.",
                                fontSize = TextUnit(20F, TextUnitType.Sp),
                                color = Color.White
                            )
                        } else {
                            outputs.forEach {
                                Text(it.pathString)
                            }
                        }
                        Spacer(Modifier.height(24.dp))
                        Button(
                            onClick = {
                                showDirectoryPicker({
                                    Logger.info("Path: ${it.absolutePath}")
                                    entry.map.add(it.toPath())
                                    outputs.add(it.toPath())
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