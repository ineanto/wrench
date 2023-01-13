package xyz.atnrch.wrench.gui

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import xyz.atnrch.wrench.gui.filemanager.bottom.FileBottomRow
import xyz.atnrch.wrench.gui.style.UIColors
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
        backgroundColor = UIColors.DARK_PRIMARY
    ) {
        FileBottomRow(minMode, watcherManager, watcher, currentClick, outputs, onCurrentClick)
    }
}