package xyz.atnrch.wrench.components.center.input

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.registery.ACTIVE_COMPOSABLE
import xyz.atnrch.wrench.registery.RegisterComposable
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun InputEntries(
    watcherManager: WatcherManager,
    onEntryClick: (id: Int) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(0.5f)
            .border(BorderStroke(4.dp, UIColors.ORANGE), RectangleShape)
            .clickable {
                ACTIVE_COMPOSABLE = -1
                onEntryClick.invoke(-1)
            }
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