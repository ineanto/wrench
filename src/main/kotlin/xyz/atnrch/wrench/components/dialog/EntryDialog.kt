package xyz.atnrch.wrench.components.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun EntryDialog(
    onStateChange: (state: Boolean) -> Unit
) {
    Dialog(
        onCloseRequest = { onStateChange(false) },
        resizable = false,
    ) {
        Card(
            elevation = 8.dp,
            shape = RoundedCornerShape(12.dp)
        ) {
            // Buttons
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalAlignment = Alignment.Bottom
            ) {
                TextButton(onClick = { onStateChange(false) }) {
                    Text(text = "Cancel")
                }
                Spacer(modifier = Modifier.width(4.dp))
                TextButton(onClick = {}) {
                    Text(text = "OK")
                }
            }
        }
    }
}