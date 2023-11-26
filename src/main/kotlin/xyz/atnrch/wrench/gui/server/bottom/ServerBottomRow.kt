package xyz.atnrch.wrench.gui.server.bottom

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ServerButtonBar(
    minMode: Boolean,
    currentClick: Int,
    onCurrentClick: (Int) -> Unit,
) {
    Spacer(Modifier.width(10.dp))
    StartServerStateButton(minMode)
    /*if (currentClick != -1) {
        Spacer(Modifier.width(10.dp))
        AddOutputButton(minMode, watcherManager, outputs, currentClick)
        Spacer(Modifier.width(10.dp))
        RemoveOutputButton(minMode, watcherManager, outputs, currentClick, onCurrentClick)
    }*/
}