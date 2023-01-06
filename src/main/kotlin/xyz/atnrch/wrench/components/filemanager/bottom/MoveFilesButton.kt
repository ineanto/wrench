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
import androidx.compose.material.icons.filled.Update
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.Watcher

@Composable
fun MoveFilesButton(
    state: WindowState,
    watcher: Watcher
) {
    Button(
        onClick = { watcher.move() },
        colors = ButtonDefaults.buttonColors(UIColors.DARK, Color.White),
        contentPadding = PaddingValues(
            start = 14.dp,
            top = 6.dp,
            end = 14.dp,
            bottom = 6.dp
        ),
        shape = RoundedCornerShape(100),
        border = BorderStroke(2.dp, UIColors.GREEN),
        modifier = Modifier.shadow(24.dp, RoundedCornerShape(100), false)
    ) {
        Icon(
            Icons.Filled.Update,
            tint = UIColors.GREEN,
            contentDescription = "Start",
            modifier = Modifier.size(22.dp)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Move files")
    }
}