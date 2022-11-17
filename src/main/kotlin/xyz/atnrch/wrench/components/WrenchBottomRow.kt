package xyz.atnrch.wrench.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.colors.WrenchColors
import xyz.atnrch.wrench.watcher.Watcher

@Composable
fun BottomRow(
    watcher: Watcher,
    state: Boolean,
    onStateChange: (state: Boolean) -> Unit
) {
    //.............
    // START BUTTON
    //.............
    Spacer(Modifier.width(5.dp))
    Button(
        {
            if (state) {
                run { watcher.stop() }
                onStateChange(false)
            } else {
                run { watcher.start() }
                onStateChange(true)
            }
        },
        colors = ButtonDefaults.buttonColors(WrenchColors.LIGHT, Color.White),
        contentPadding = ButtonDefaults.ContentPadding,
        shape = RoundedCornerShape(100),
        modifier = Modifier.shadow(15.dp, RoundedCornerShape(100), false)
    ) {
        if (state) Icon(
            Icons.Filled.Close,
            contentDescription = "Stop",
            modifier = Modifier.size(28.dp)
        ) else Icon(
            Icons.Filled.PlayArrow,
            tint = Color.White,
            contentDescription = "Start",
            modifier = Modifier.size(28.dp)
        )
    }
}