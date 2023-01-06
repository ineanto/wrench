package xyz.atnrch.wrench.components

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import xyz.atnrch.wrench.components.filemanager.bottom.bar.NormalFileBottomRow
import xyz.atnrch.wrench.components.filemanager.bottom.bar.SmallFileBottomRow
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun AppBottomBar(
    minMode: Boolean,
    watcherManager: WatcherManager,
    watcher: Watcher,
    currentClick: Int,
    outputs: MutableList<Path>,
    onCurrentClick: (Int) -> Unit
) {
    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        ),
        backgroundColor = UIColors.DARK
    ) {
        if (minMode)
            NormalFileBottomRow(watcherManager, watcher, currentClick, outputs, onCurrentClick)
        else
            SmallFileBottomRow(watcherManager, watcher, currentClick, outputs, onCurrentClick)
    }
}