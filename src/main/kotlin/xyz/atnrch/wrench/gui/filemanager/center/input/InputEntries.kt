package xyz.atnrch.wrench.gui.filemanager.center.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.appearance.UIColors
import xyz.atnrch.wrench.gui.component.ACTIVE_COMPOSABLE
import xyz.atnrch.wrench.gui.component.RegisterComposable
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun InputEntries(
    minMode: Boolean,
    watcherManager: WatcherManager,
    onEntryClick: (id: Int) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = getBoxModifier(minMode, onEntryClick)
    ) {
        InputTopText()
        Column(
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            watcherManager.getEntries().forEach {
                RegisterComposable(it.key) {
                    InputTextEntry(
                        it.key,
                        it.value,
                        onEntryClick
                    )
                }
            }
        }
    }
}

@Composable
private fun getBoxModifier(
    minMode: Boolean,
    onEntryClick: (id: Int) -> Unit
): Modifier {
    val modifier: Modifier = Modifier.border(BorderStroke(4.dp, UIColors.ORANGE), RectangleShape)
        .clickable {
            ACTIVE_COMPOSABLE = -1
            onEntryClick.invoke(-1)
        }

    return if (minMode)
        modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
    else modifier
        .fillMaxHeight()
        .fillMaxWidth(0.5f)
}
