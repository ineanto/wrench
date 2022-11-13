package xyz.atnrch.wrench.display

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WrenchDisplay(
    onStartButtonClick: () -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Row {

            Button(onStartButtonClick) {
                Text("Watch")
            }
            Spacer(Modifier.width(16.dp))
            Button({}) {
                Text("Stop")
            }
            Spacer(Modifier.width(16.dp))
            Button({}) {
                Text("Add...")
            }
        }
    }
}