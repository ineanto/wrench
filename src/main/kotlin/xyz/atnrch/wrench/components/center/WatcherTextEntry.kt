package xyz.atnrch.wrench.components.center

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.PointerMatcher
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.onClick
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerButton
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import xyz.atnrch.wrench.components.center.dialog.EntryDialog
import xyz.atnrch.wrench.registery.ACTIVE_COMPOSABLE
import xyz.atnrch.wrench.ui.Fonts
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager

@OptIn(ExperimentalUnitApi::class, ExperimentalFoundationApi::class)
@Composable
fun WatcherTextEntry(
    id: Int,
    entry: WatcherEntry,
    watcherManager: WatcherManager,
    onEntrySelected: (id: Int) -> Unit,
    interactionSource: MutableInteractionSource,
) {
    var dialogState by remember { mutableStateOf(false) }

    Text(
        text = "${entry.file.absolutePath}",
        style = TextStyle(
            color = if(ACTIVE_COMPOSABLE == id) Color.Red else Color.Black,
            fontSize = TextUnit(15F, TextUnitType.Sp),
            fontFamily = Fonts.ROBOTO_REGULAR
        ),
        modifier = Modifier
            .onClick(
                matcher = PointerMatcher.mouse(PointerButton.Primary),
                interactionSource = interactionSource,
                onClick = {
                    println("Active composable ID was $ACTIVE_COMPOSABLE")
                    ACTIVE_COMPOSABLE = id
                    println("Active composable ID is now $ACTIVE_COMPOSABLE")
                    if (ACTIVE_COMPOSABLE == id) {
                        onEntrySelected.invoke(id)
                    }
                }
            )
            .onClick(
                matcher = PointerMatcher.mouse(PointerButton.Secondary),
                onClick = {
                    dialogState = true
                    println("PATH IS ${watcherManager.getFromId(ACTIVE_COMPOSABLE)!!.file.path}")
                }
            )
    )

    if (dialogState) {
        EntryDialog(onStateChange = { dialogState = it })
    }
}