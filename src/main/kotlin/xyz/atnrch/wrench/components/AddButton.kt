package xyz.atnrch.wrench.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun AddButton(
    watcherManager: WatcherManager
) {
    //.............
    // ADD BUTTON (FLOATING)
    //.............
    FloatingActionButton(
        {
            createFileChooser({
                Logger.info("Path: ${it.absolutePath}")
                watcherManager.addFile(it)
            }, {
                Logger.info("No file selected.")
            })
        },
        backgroundColor = UIColors.LIGHT,
    ) {
        Icon(
            Icons.Filled.Add,
            tint = UIColors.GREEN,
            contentDescription = "Add file...",
            modifier = Modifier.size(28.dp)
        )
    }
}