package xyz.atnrch.wrench.display.status

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
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
            Text(startStopButtonText)
        }
        Spacer(Modifier.width(10.dp))
        Button(onAddButtonClick) {
            Text("Add...")
        }
        Spacer(Modifier.width(10.dp))
    }
}