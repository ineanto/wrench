package xyz.atnrch.wrench.display.status

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WrenchStatus(
    onStartButtonClick: () -> Unit,
    onStopButtonClick: () -> Unit,
    onAddButtonClick: () -> Unit
) {
    val padding = PaddingValues(
        start = 13.dp,
        top = 10.dp,
        end = 13.dp,
        bottom = 10.dp
    )
    var status by remember { mutableStateOf(false) }
    var startStopButtonText by remember { mutableStateOf("Start") }

    Row {
        Button(
            {
                status = if (status) {
                    onStopButtonClick.invoke()
                    false
                } else {
                    onStartButtonClick.invoke()
                    true
                }
                startStopButtonText = if (status) "Stop" else "Start"
            }, contentPadding = padding
        ) {
            if (status) Icon(
                Icons.Filled.Close,
                contentDescription = "Start",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            ) else Icon(
                Icons.Filled.PlayArrow,
                tint = Color.White,
                contentDescription = "Start",
                modifier = Modifier.size(24.dp)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(startStopButtonText)
        }
        Spacer(Modifier.width(10.dp))
        Button(
            onAddButtonClick,
            contentPadding = padding
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Add",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Add...")
        }
        Spacer(Modifier.width(10.dp))
    }
}