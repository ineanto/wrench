package xyz.atnrch.wrench.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.QuestionMark
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.components.center.input.InputEntries
import xyz.atnrch.wrench.components.center.output.OutputEntries
import xyz.atnrch.wrench.ui.Fonts
import xyz.atnrch.wrench.watcher.WatcherManager
import java.io.File

@Composable
fun WatcherDisplay(watcherManager: WatcherManager) {
    var currentClick by remember { mutableStateOf(-1) }
    Row(
        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 55.dp)
    ) {
        if (watcherManager.getEntries().isEmpty()) {
            watcherManager.addFile(File("/home/aro/IdeaProjects/Wrench/dummy"))
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth().fillMaxHeight()
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Icon(
                        imageVector = Icons.Rounded.QuestionMark,
                        tint = Color.White,
                        contentDescription = "Open Folder",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text(
                        text = "Add a file to start...",
                        fontFamily = Fonts.ROBOTO_REGULAR,
                        color = Color.White
                    )
                }
            }
        } else {
            InputEntries(watcherManager) { currentClick = it }
            OutputEntries(watcherManager, currentClick)
        }
    }
}
