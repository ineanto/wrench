package xyz.atnrch.wrench.components.filemanager.bottom.bar

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import xyz.atnrch.wrench.components.filemanager.bottom.AddOutputButton
import xyz.atnrch.wrench.components.filemanager.bottom.MoveFilesButton
import xyz.atnrch.wrench.components.filemanager.bottom.RemoveOutputButton
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun SmallFileBottomRow(
    state: WindowState,
    watcherManager: WatcherManager,
    watcher: Watcher,
    currentClick: Int,
    outputs: MutableList<Path>,
    onCurrentClick: (Int) -> Unit,
) {
    Spacer(Modifier.width(10.dp))
    MoveFilesButton(state, watcher)
    if (currentClick != -1) {
        Spacer(Modifier.width(10.dp))
        AddOutputButton(watcherManager, outputs, currentClick)
        Spacer(Modifier.width(10.dp))
        RemoveOutputButton(watcherManager, outputs, currentClick, onCurrentClick)
    }
}