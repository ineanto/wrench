package xyz.atnrch.wrench.components.filemanager.bottom

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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import xyz.atnrch.wrench.components.filemanager.center.showDirectoryPicker
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun AddOutputButton(
    state: WindowState,
    watcherManager: WatcherManager,
    outputs: MutableList<Path>,
    currentClick: Int
) {
    val scaleFactor: Float = if (state.size.width <= 600.dp) 0.85f else 1f

    Button(
        onClick =
        {
            val entry: WatcherEntry? = watcherManager.getFromId(currentClick)
            showDirectoryPicker({
                Logger.info("Path: ${it.absolutePath}")
                entry!!.map.add(it.toPath())
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
        modifier = Modifier.shadow(24.dp, RoundedCornerShape(100), false).scale(scaleFactor)
    ) {
        Icon(
            Icons.Filled.NoteAdd,
            tint = UIColors.ORANGE,
            contentDescription = "Add output",
            modifier = Modifier.size(22.dp)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Add output...")
    }
}