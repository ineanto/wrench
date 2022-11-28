package xyz.atnrch.wrench.components.bottom

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun BottomAppBar(
    watcherManager: WatcherManager,
    watcher: Watcher,
    currentClick: Int,
    outputs: MutableList<Path>
) {
    androidx.compose.material.BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        ),
        backgroundColor = UIColors.DARK
    ) { BottomRowNew(watcherManager, watcher, currentClick, outputs) }
}