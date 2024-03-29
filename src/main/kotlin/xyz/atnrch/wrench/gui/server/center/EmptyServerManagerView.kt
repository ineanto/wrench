package xyz.atnrch.wrench.gui.server.center

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Flag
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.appearance.Fonts
import xyz.atnrch.wrench.gui.appearance.UIColors

@Composable
fun UnderConstructionView() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Column (
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Rounded.Flag,
                tint = UIColors.ORANGE,
                contentDescription = "Icon",
                modifier = Modifier.size(58.dp)
            )
            Spacer(Modifier.height(24.dp))
            Text(
                text = "Start by adding or clicking an existing server.",
                fontFamily = Fonts.ROBOTO_BOLD,
                fontSize = TextUnit(20F, TextUnitType.Sp),
                color = Color.White
            )
        }
    }
}