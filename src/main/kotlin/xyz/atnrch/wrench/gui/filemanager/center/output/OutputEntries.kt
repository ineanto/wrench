package xyz.atnrch.wrench.gui.filemanager.center.output

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.style.UIColors
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path
import kotlin.io.path.pathString

@OptIn(ExperimentalUnitApi::class)
@Composable
fun OutputEntries(
    watcherManager: WatcherManager,
    currentClick: Int,
    outputs: MutableList<Path>
) {
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
            val entry: WatcherEntry? = watcherManager.getFromId(currentClick)
            if (entry != null) {
                outputs.clear()
                outputs.addAll(entry.outputs)

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
                                Text(
                                    text = it.pathString,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}