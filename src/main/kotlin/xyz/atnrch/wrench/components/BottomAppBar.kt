package xyz.atnrch.wrench.components

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import xyz.atnrch.wrench.colors.WrenchColors
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
        backgroundColor = WrenchColors.PRIMARY
    ) { BottomRow(watcher, state, onStateChange) }
}