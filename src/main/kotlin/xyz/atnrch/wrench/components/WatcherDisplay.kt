package xyz.atnrch.wrench.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import xyz.atnrch.wrench.components.center.input.InputEntries
import xyz.atnrch.wrench.components.center.output.OutputEntries
import xyz.atnrch.wrench.watcher.WatcherManager
import java.io.File

@Composable
fun WatcherDisplay(
    watcherManager: WatcherManager
) {
    var currentClick by remember { mutableStateOf(-1) }
    val interactionSource = remember { MutableInteractionSource() }

    Row {
        if (watcherManager.getEntries().isEmpty()) {
            watcherManager.addFile(File("/home/aro/IdeaProjects/Wrench/dummy"))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            ) {
                Text("Add a file to start...")
            }
        } else {
            InputEntries(watcherManager, interactionSource) { currentClick = it }
            OutputEntries(watcherManager, currentClick)
        }
    }
}
