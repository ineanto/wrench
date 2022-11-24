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
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.components.dialog.EntryDialog
import xyz.atnrch.wrench.ui.Fonts
import xyz.atnrch.wrench.watcher.WatcherEntry

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WatcherTextEntry(entry: WatcherEntry) {
    var dialogState by remember { mutableStateOf(false) }

    Text(
        text = "${entry.file.absolutePath}",
        style = TextStyle(
            color = Color.Black,
            fontSize = TextUnit(15F, TextUnitType.Sp),
            fontFamily = Fonts.ROBOTO_REGULAR
        ),
        modifier = Modifier.clickable {
            dialogState = true
        }
    )
    Spacer(Modifier.height(15.dp))

    if (dialogState) {
        EntryDialog(onStateChange = { dialogState = it })
    }
}