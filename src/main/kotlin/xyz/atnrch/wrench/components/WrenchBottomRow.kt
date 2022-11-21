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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.Watcher

@Composable
fun BottomRow(
    watcher: Watcher,
    state: Boolean,
    onStateChange: (state: Boolean) -> Unit
) {
    val buttonColors = remember { arrayOf(UIColors.WATCHER_START_BG) }

    //.............
    // START BUTTON
    //.............
    Spacer(Modifier.width(5.dp))
    Button(
        {
            if (state) {
                buttonColors[0] = UIColors.WATCHER_START_BG
                run { watcher.stop() }
                onStateChange(false)
            } else {
                buttonColors[0] = UIColors.WATCHER_STOP_BG
                run { watcher.start() }
                onStateChange(true)
            }
        },
        colors = ButtonDefaults.buttonColors(buttonColors[0], Color.White),
        contentPadding = ButtonDefaults.ContentPadding,
        shape = RoundedCornerShape(100),
        modifier = Modifier.shadow(15.dp, RoundedCornerShape(100), false)
    ) {
        if (state) {
            Icon(
                Icons.Filled.Close,
                tint = UIColors.WATCHER_STOP_FG,
                contentDescription = "Stop",
                modifier = Modifier.size(28.dp)
            )
        } else {
            Icon(
                Icons.Filled.PlayArrow,
                tint = UIColors.WATCHER_START_FG,
                contentDescription = "Start",
                modifier = Modifier.size(28.dp)
            )
        }
    }
}