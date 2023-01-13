package xyz.atnrch.wrench.gui.filemanager.top

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.style.Fonts
import xyz.atnrch.wrench.gui.style.UIColors
import xyz.atnrch.wrench.json.JsonLayout
import xyz.atnrch.wrench.watcher.WatcherEntry

@Composable
fun TopBar(
    jsonLayout: JsonLayout,
    tabIndex: Int,
    values: MutableCollection<WatcherEntry>
) {
    TopAppBar(
        backgroundColor = UIColors.DARK_PRIMARY,
        contentColor = Color.White,
        elevation = 16.dp,
        title = {
            Icon(
                Icons.Filled.Build,
                tint = Color.White,
                contentDescription = "Wrench Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(Modifier.width(5.dp))
            Text(
                text = "Wrench",
                fontFamily = Fonts.JOST_MEDIUM
            )
        },
        actions = {
            if (tabIndex == 0) {
                TopBarButtons(jsonLayout, values)
            }
        }
    )
}