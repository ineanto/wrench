package xyz.atnrch.wrench.gui.filemanager.bottom

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun FileBottomRow(
    minMode: Boolean,
    watcherManager: WatcherManager,
    watcher: Watcher,
    currentClick: Int,
    outputs: MutableList<Path>,
    onCurrentClick: (Int) -> Unit,
) {
    Spacer(Modifier.width(10.dp))
    MoveFilesButton(minMode, watcher)
    if (currentClick != -1) {
        Spacer(Modifier.width(10.dp))
        AddOutputButton(minMode, watcherManager, outputs, currentClick)
        Spacer(Modifier.width(10.dp))
        RemoveOutputButton(minMode, watcherManager, outputs, currentClick, onCurrentClick)
    }
}