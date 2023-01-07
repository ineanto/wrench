package xyz.atnrch.wrench.gui.filemanager.center.input

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Input
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalUnitApi::class)
@Composable
fun InputTopText() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(PaddingValues(0.dp, 24.dp, 0.dp, 55.dp))
            .fillMaxHeight()
            .fillMaxWidth(0.5f)
    ) {
        Row {
            Text(
                text = "Input",
                color = Color.White,
                fontSize = TextUnit(20F, TextUnitType.Sp)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Icon(
                Icons.Filled.Input,
                tint = Color.White,
                contentDescription = "Input",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}