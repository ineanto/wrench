package xyz.atnrch.wrench.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Update
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.compose.SnackBarDataHolder
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.Watcher

@Composable
fun BottomRow(
    watcher: Watcher,
    state: Boolean,
    onStateChange: (state: Boolean) -> Unit,
    snackBarDataHolder: SnackBarDataHolder
) {
    val buttonColors = remember { arrayOf(UIColors.WATCHER_START_BG) }

    Spacer(Modifier.width(5.dp))
    /*Button(
        {
            if (state) {
                buttonColors[0] = UIColors.WATCHER_START_BG
                run { watcher.stop() }
                onStateChange(false)
                snackBarDataHolder.coroutineScope.launch {
                    snackBarDataHolder.scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                    snackBarDataHolder.scaffoldState.snackbarHostState.showSnackbar(
                        message = "Stopped Watcher.",
                        duration = SnackbarDuration.Short,
                    )
                }
            } else {
                buttonColors[0] = UIColors.WATCHER_STOP_BG
                run { watcher.start() }
                onStateChange(true)
                snackBarDataHolder.coroutineScope.launch {
                    snackBarDataHolder.scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                    snackBarDataHolder.scaffoldState.snackbarHostState.showSnackbar(
                        message = "Started Watcher.",
                        duration = SnackbarDuration.Short
                    )
                }
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
    }*/
    Button(
        onClick = { watcher.move() },
        colors = ButtonDefaults.buttonColors(UIColors.PRIMARY, Color.White),
        contentPadding = PaddingValues(
            start = 18.dp,
            top = 6.dp,
            end = 18.dp,
            bottom = 6.dp
        ),
        shape = RoundedCornerShape(100),
        border = BorderStroke(2.dp, UIColors.WATCHER_START_FG),
        modifier = Modifier.shadow(24.dp, RoundedCornerShape(100), false)
    ) {
        Icon(
            Icons.Filled.Update,
            tint = UIColors.WATCHER_START_FG,
            contentDescription = "Start",
            modifier = Modifier.size(22.dp)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text("Move files")
    }

}