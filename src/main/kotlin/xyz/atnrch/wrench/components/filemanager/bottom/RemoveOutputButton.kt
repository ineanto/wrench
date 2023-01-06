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
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.registery.ACTIVE_COMPOSABLE
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherManager
import java.nio.file.Path

@Composable
fun RemoveOutputButton(
    minMode: Boolean,
    watcherManager: WatcherManager,
    outputs: MutableList<Path>,
    currentClick: Int,
    onCurrentClick: (Int) -> Unit
) {
    Button(
        onClick =
        {
            watcherManager.removeFile(currentClick)
            outputs.clear()
            ACTIVE_COMPOSABLE = -1
            onCurrentClick.invoke(-1)
        },
        colors = ButtonDefaults.buttonColors(UIColors.DARK, Color.White),
        contentPadding = PaddingValues(
            start = 14.dp,
            top = 6.dp,
            end = 14.dp,
            bottom = 6.dp
        ),
        shape = RoundedCornerShape(100),
        border = BorderStroke(2.dp, UIColors.STRESS),
        modifier = Modifier.shadow(24.dp, RoundedCornerShape(100), false)
    ) {
        Icon(
            Icons.Filled.Delete,
            tint = UIColors.STRESS,
            contentDescription = "Remove file",
            modifier = Modifier.size(22.dp)
        )
        if (!minMode) {
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Delete input")
        }
    }
}
