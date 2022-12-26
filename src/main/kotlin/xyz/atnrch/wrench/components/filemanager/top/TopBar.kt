package xyz.atnrch.wrench.components.filemanager.top

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
import xyz.atnrch.wrench.ui.Fonts
import xyz.atnrch.wrench.ui.UIColors

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = UIColors.DARK,
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
        }
    )
}