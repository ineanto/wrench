package xyz.atnrch.wrench.components

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.Watcher

@Composable
fun BottomAppBar(
    watcher: Watcher,
    state: Boolean,
    onStateChange: (state: Boolean) -> Unit
) {
    androidx.compose.material.BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        ),
        backgroundColor = UIColors.PRIMARY,
        modifier = Modifier.shadow(20.dp, MaterialTheme.shapes.small, true)
    ) { BottomRow(watcher, state, onStateChange) }
}