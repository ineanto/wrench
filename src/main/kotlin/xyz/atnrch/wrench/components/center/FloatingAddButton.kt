package xyz.atnrch.wrench.components.center

import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PostAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun AddButton(
    watcherManager: WatcherManager
) {
    FloatingActionButton(
        {
            createFileChooser({
                Logger.info("Path: ${it.absolutePath}")
                watcherManager.addFile(it)
            }, {
                Logger.info("No file selected.")
            })
        },
        backgroundColor = UIColors.PRIMARY,
    ) {
        Icon(
            Icons.Rounded.PostAdd,
            tint = Color.White,
            contentDescription = "Add file...",
            modifier = Modifier.size(28.dp)
        )
    }
}