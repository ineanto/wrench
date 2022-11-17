package xyz.atnrch.wrench.scaffold

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WrenchScaffold() {
    Scaffold(
        topBar = {
            TopAppBar {
                Text("Wrench")
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* ... */ },
                backgroundColor = Color.Black
            ) {
                Icon(
                    Icons.Filled.PlayArrow,
                    tint = Color.White,
                    contentDescription = "Start",
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                ),
                backgroundColor = Color.Black
            ) {

            }
        }
    ) {
        // Screen content
    }

}