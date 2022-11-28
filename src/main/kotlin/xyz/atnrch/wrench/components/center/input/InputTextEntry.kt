package xyz.atnrch.wrench.components.center.input

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.PointerMatcher
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
import xyz.atnrch.wrench.ui.UIColors
import xyz.atnrch.wrench.watcher.WatcherEntry

@OptIn(ExperimentalUnitApi::class, ExperimentalFoundationApi::class)
@Composable
fun InputTextEntry(
    id: Int,
    entry: WatcherEntry,
    onEntrySelected: (id: Int) -> Unit
) {
    var dialogState by remember { mutableStateOf(false) }

    Text(
        text = entry.file.absolutePath,
        style = TextStyle(
            color = if(ACTIVE_COMPOSABLE == id) UIColors.GREEN else Color.White,
            fontSize = TextUnit(17F, TextUnitType.Sp),
            fontFamily = if(ACTIVE_COMPOSABLE == id) Fonts.ROBOTO_BOLD else Fonts.ROBOTO_REGULAR
        ),
        modifier = Modifier
            .onClick(
                matcher = PointerMatcher.mouse(PointerButton.Primary),
                onClick = {
                    ACTIVE_COMPOSABLE = id
                    onEntrySelected.invoke(id)
                }
            )
            .onClick(
                matcher = PointerMatcher.mouse(PointerButton.Secondary),
                onClick = {
                    dialogState = true
                }
            )
    )

    if (dialogState) {
        EntryDialog(onStateChange = { dialogState = it })
    }
}