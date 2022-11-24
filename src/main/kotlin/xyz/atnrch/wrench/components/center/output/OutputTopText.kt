package xyz.atnrch.wrench.components.center.output

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Output
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun OutputTopText() {
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(PaddingValues(0.dp, 24.dp, 0.dp, 55.dp))
            .fillMaxHeight()
            .fillMaxWidth(0.5f)
    ) {
        Row {
            Icon(
                Icons.Filled.Output,
                tint = Color.Black,
                contentDescription = "Output",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.width(5.dp))
            Text("Output")
        }
    }
}