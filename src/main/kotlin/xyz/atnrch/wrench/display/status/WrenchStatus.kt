package xyz.atnrch.wrench.display.status

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp

@Composable
fun WrenchStatus(
    onStartButtonClick: () -> Unit,
    onStopButtonClick: () -> Unit,
    onAddButtonClick: () -> Unit
) {
    var status by remember { mutableStateOf(false) }
    var startStopButtonText by remember { mutableStateOf("Start") }

    Row {
        Button({
            status = if (status) {
                onStopButtonClick.invoke()
                false
            } else {
                onStartButtonClick.invoke()
                true
            }
            startStopButtonText = if (status) "Stop" else "Start"
        }) {
            if (status) Icon(
                Icons.Filled.Close,
                contentDescription = "Start",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            ) else Icon(
                Icons.Filled.PlayArrow,
                contentDescription = "Start",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(startStopButtonText)
        }
        Spacer(Modifier.width(10.dp))
        Button(onAddButtonClick) {
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