package xyz.atnrch.wrench.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import xyz.atnrch.wrench.components.dialog.EntryDialog
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
            dialogState = true
        }
    )

    if (dialogState) {
        EntryDialog(
            onCancelClick = {
                dialogState = false
                println("clicked cancel")
            },
            onStateChange = { dialogState = it }
        )
    }
}