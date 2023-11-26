package xyz.atnrch.wrench.gui.server.bottom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Start
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.appearance.UIColors

@Composable
fun StartServerStateButton(
    minMode: Boolean,
) {
    Button(
        onClick =
        {
        },
        colors = ButtonDefaults.buttonColors(UIColors.DARK_PRIMARY, Color.White),
        contentPadding = PaddingValues(
            start = 14.dp,
            top = 6.dp,
            end = 14.dp,
            bottom = 6.dp
        ),
        shape = RoundedCornerShape(100),
        border = BorderStroke(2.dp, UIColors.GREEN),
        modifier = Modifier.shadow(24.dp, RoundedCornerShape(100), false)
    ) {
        Icon(
            Icons.Filled.Start,
            tint = UIColors.GREEN,
            contentDescription = "Start Server",
            modifier = Modifier.size(22.dp)
        )
        if(!minMode) {
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Start")
        }
    }
}