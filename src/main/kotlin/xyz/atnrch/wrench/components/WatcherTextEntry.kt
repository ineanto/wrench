package xyz.atnrch.wrench.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import xyz.atnrch.wrench.watcher.WatcherEntry

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WatcherTextEntry(entry: WatcherEntry) {
    var dialogState by remember { mutableStateOf(false) }

    Text(
        text = "${entry.file.absolutePath}",
        style = TextStyle(
            color = Color.Black,
            fontSize = TextUnit(15F, TextUnitType.Sp)
        ),
        modifier = Modifier.clickable {
            if (dialogState) {
                Dialog(
                    onCloseRequest = { dialogState = false },
                    resizable = false,
                ) {
                    Card(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        // Buttons
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {

                            TextButton(onClick = {}) {
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
        }
    )
}