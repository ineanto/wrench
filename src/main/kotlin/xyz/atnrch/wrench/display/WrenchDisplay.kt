package xyz.atnrch.wrench.display

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import xyz.atnrch.wrench.display.file.WrenchFileManagerInput
import xyz.atnrch.wrench.display.file.WrenchFileManagerOutput
import xyz.atnrch.wrench.display.status.WrenchStatus

@Composable
fun WrenchDisplay(
    onStartButtonClick: () -> Unit,
    onStopButtonClick: () -> Unit,
    onAddButtonClick: () -> Unit
) {
    Box {
        WrenchFileManagerInput()
        WrenchFileManagerOutput()
    }
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = Modifier.fillMaxSize()
    ) {
        WrenchStatus(onStartButtonClick, onStopButtonClick, onAddButtonClick)
    }
}