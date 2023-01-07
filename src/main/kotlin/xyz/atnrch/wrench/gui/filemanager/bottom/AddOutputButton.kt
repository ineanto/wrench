package xyz.atnrch.wrench.gui.filemanager.bottom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.filemanager.center.showDirectoryPicker
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.gui.style.UIColors
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun AddOutputButton(
    minMode: Boolean,
    watcherManager: WatcherManager,
    outputs: MutableList<Path>,
    currentClick: Int
) {
    Button(
        onClick =
        {
            val entry: WatcherEntry = watcherManager.getFromId(currentClick)!!
            showDirectoryPicker({
                Logger.info("Path: ${it.absolutePath}")
                entry.outputs.add(it.toPath())
                outputs.add(it.toPath())
            }, {
                Logger.info("No file selected.")
            })
        },
        colors = ButtonDefaults.buttonColors(UIColors.DARK, Color.White),
        contentPadding = PaddingValues(
            start = 14.dp,
            top = 6.dp,
            end = 14.dp,
            bottom = 6.dp
        ),
        shape = RoundedCornerShape(100),
        border = BorderStroke(2.dp, UIColors.ORANGE),
        modifier = Modifier.shadow(24.dp, RoundedCornerShape(100), false)
    ) {
        Icon(
            Icons.Filled.NoteAdd,
            tint = UIColors.ORANGE,
            contentDescription = "Add output",
            modifier = Modifier.size(22.dp)
        )
        if(!minMode) {
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Add output...")
        }
    }
}