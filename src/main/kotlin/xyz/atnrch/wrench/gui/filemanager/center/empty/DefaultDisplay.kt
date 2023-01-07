package xyz.atnrch.wrench.gui.filemanager.center.empty

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FolderOff
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.style.Fonts
import xyz.atnrch.wrench.gui.style.UIColors

@OptIn(ExperimentalUnitApi::class)
@Composable
fun DefaultDisplay() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Rounded.FolderOff,
                tint = UIColors.ORANGE,
                contentDescription = "Open Folder",
                modifier = Modifier.size(58.dp)
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Add a file to start...",
                fontFamily = Fonts.ROBOTO_BOLD,
                fontSize = TextUnit(20F, TextUnitType.Sp),
                color = Color.White
            )
        }
    }
}