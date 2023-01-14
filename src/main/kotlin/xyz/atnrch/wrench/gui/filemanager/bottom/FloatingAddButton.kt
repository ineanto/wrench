package xyz.atnrch.wrench.gui.filemanager.bottom

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PostAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.appearance.UIColors
import xyz.atnrch.wrench.gui.filemanager.center.showFilePicker
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun FloatingAddButton(
    watcherManager: WatcherManager
) {
    FloatingActionButton(
        {
            showFilePicker({
                Logger.info("Path: ${it.absolutePath}")
                watcherManager.addFile(it)
            }, {
                Logger.info("No file selected.")
            })
        },
        backgroundColor = UIColors.DARK_PRIMARY,
        modifier = Modifier.border(
            4.dp,
            UIColors.ORANGE,
            MaterialTheme.shapes.small.copy(
                CornerSize(percent = 50)
            )
        )
    ) {
        Icon(
            Icons.Rounded.PostAdd,
            tint = Color.White,
            contentDescription = "Add file...",
            modifier = Modifier.size(32.dp)
        )
    }
}