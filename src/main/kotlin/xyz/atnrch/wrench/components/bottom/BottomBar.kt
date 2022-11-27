package xyz.atnrch.wrench.components.bottom

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.Watcher

@Composable
fun BottomAppBar(
    watcher: Watcher
) {
    androidx.compose.material.BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        ),
        backgroundColor = UIColors.PRIMARY
    ) { BottomRowNew(watcher) }
}