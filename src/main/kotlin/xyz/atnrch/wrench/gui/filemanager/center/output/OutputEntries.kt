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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.appearance.Fonts
import xyz.atnrch.wrench.gui.appearance.UIColors
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path
import kotlin.io.path.pathString

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
            .border(BorderStroke(4.dp, UIColors.LIGHT_RED), RectangleShape)
    ) {
        OutputTopText()
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val entry: WatcherEntry? = watcherManager.getFromId(currentClick)
            if (entry != null) {
                outputs.clear()
                outputs.addAll(entry.outputs)

                if (outputs.isEmpty()) Text(
                    text = "This file does not have any output location.",
                    fontSize = TextUnit(17F, TextUnitType.Sp),
                    fontFamily = Fonts.ROBOTO_BOLD,
                    color = Color.White
                ) else outputs.forEach {
                    Text(
                        text = it.pathString,
                        fontSize = TextUnit(17F, TextUnitType.Sp),
                        fontFamily = Fonts.ROBOTO_REGULAR,
                        color = Color.White
                    )
                }
            }
        }
    }
}