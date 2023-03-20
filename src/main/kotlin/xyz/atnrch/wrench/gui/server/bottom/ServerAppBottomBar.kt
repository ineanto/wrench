package xyz.atnrch.wrench.gui.server.bottom

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import xyz.atnrch.wrench.gui.appearance.UIColors

@Composable
fun ServerAppBottomBar(
    minMode: Boolean,
    currentClick: Int,
    onCurrentClick: (Int) -> Unit
) {
    BottomAppBar(
        cutoutShape = MaterialTheme.shapes.small.copy(
            CornerSize(percent = 50)
        ),
        backgroundColor = UIColors.DARK_PRIMARY
    ) {
        ServerButtonBar(minMode, currentClick, onCurrentClick)
    }
}