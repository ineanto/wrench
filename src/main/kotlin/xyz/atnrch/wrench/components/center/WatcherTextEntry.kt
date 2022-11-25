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
import xyz.atnrch.wrench.components.center.dialog.EntryDialog
import xyz.atnrch.wrench.registery.ACTIVE_COMPOSABLE
import xyz.atnrch.wrench.ui.Fonts
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager

@OptIn(ExperimentalUnitApi::class)
@Composable
fun WatcherTextEntry(id: Int, entry: WatcherEntry, watcherManager: WatcherManager) {
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
            ACTIVE_COMPOSABLE = id
            println("PATH IS ${watcherManager.getFromId(ACTIVE_COMPOSABLE)!!.file.path}")
        }
    )

    if (dialogState) {
        EntryDialog(onStateChange = { dialogState = it })
    }
}