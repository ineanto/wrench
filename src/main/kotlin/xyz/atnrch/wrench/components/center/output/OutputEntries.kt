package xyz.atnrch.wrench.components.center.output

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.registery.ACTIVE_COMPOSABLE
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun OutputEntries(watcherManager: WatcherManager) {
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
            val entry: WatcherEntry? = watcherManager.getFromId(ACTIVE_COMPOSABLE)
        }
    }
}