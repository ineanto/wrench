package xyz.atnrch.wrench.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.colors.WrenchColors
import xyz.atnrch.wrench.logger.Logger

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = WrenchColors.PRIMARY,
        contentColor = Color.White,
        elevation = 16.dp,
        title = { Text("Wrench") },
        actions = {
            //.............
            // Debug Button
            //.............
            Button(
                { Logger.debug("Empty.") },
                colors = ButtonDefaults.buttonColors(WrenchColors.STRESS, Color.White),
                shape = RectangleShape
            ) {
                Icon(
                    Icons.Filled.Settings,
                    tint = Color.White,
                    contentDescription = "Debug Settings",
                    modifier = Modifier.size(18.dp)
                )
            }
            Spacer(Modifier.width(10.dp))
        })
}