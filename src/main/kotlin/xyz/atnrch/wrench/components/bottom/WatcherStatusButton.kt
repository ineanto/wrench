package xyz.atnrch.wrench.components.bottom

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import xyz.atnrch.wrench.watcher.Watcher
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun BottomRowNew(
    state: WindowState,
    watcherManager: WatcherManager,
    watcher: Watcher,
    currentClick: Int,
    outputs: MutableList<Path>,
    onCurrentClick: (Int) -> Unit,
) {
    val buttonWidth = if (state.size.width <= 600.dp) 0.dp else 10.dp

    Spacer(Modifier.width(10.dp))
    MoveFilesButton(state, watcher)
    if (currentClick != -1) {
        Spacer(Modifier.width(buttonWidth))
        AddOutputButton(state, watcherManager, outputs, currentClick)
        Spacer(Modifier.width(buttonWidth))
        RemoveOutputButton(state, watcherManager, outputs, currentClick, onCurrentClick)
    }
}