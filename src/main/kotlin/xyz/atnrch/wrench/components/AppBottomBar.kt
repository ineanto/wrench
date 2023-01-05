package xyz.atnrch.wrench.components

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.WindowState
import xyz.atnrch.wrench.components.filemanager.bottom.BottomRowNew
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun AppBottomBar(
    state: WindowState,
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
    ) { BottomRowNew(state, watcherManager, watcher, currentClick, outputs, onCurrentClick) }
}