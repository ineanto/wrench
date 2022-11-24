package xyz.atnrch.wrench.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.ui.Fonts
import xyz.atnrch.wrench.ui.UIColors

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = UIColors.PRIMARY,
        contentColor = Color.White,
        elevation = 16.dp,
        title = {
            Icon(
                Icons.Filled.Build,
                tint = Color.White,
                contentDescription = "Wrench Icon",
                modifier = Modifier.size(24.dp)
            )
            Spacer(Modifier.width(5.dp))
            Text(
                text = "Wrench",
                fontFamily = Fonts.JOST_MEDIUM
            )
        },
        actions = {
            //.............
            // Debug Button
            //.............
            Button(
                { Logger.debug("Empty.") },
                colors = ButtonDefaults.buttonColors(UIColors.STRESS, Color.White),
                shape = RectangleShape,
                modifier = Modifier
                    .width(50.dp)
                    .shadow(20.dp, RectangleShape, true)
            ) {
                Icon(
                    Icons.Filled.Star,
                    tint = Color.White,
                    contentDescription = "Debug Settings",
                    modifier = Modifier.size(24.dp).fillMaxSize()
                )
            }
            Spacer(Modifier.width(10.dp))
        })
}