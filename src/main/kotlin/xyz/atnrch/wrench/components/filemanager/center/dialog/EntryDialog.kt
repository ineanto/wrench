package xyz.atnrch.wrench.components.filemanager.center.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.sharp.FolderOpen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun EntryDialog(
    onStateChange: (state: Boolean) -> Unit
) {
    Dialog(
        onCloseRequest = { onStateChange(false) },
        resizable = true
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.size(50.dp)
                        .clip(CircleShape)
                        .background(Color.White)
                        .shadow(30.dp, CircleShape, false)
                        .height(10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Sharp.FolderOpen,
                        tint = Color.Black,
                        contentDescription = "Open Folder",
                        modifier = Modifier.size(45.dp)
                    )
                }
                Spacer(Modifier.width(75.dp))
                Icon(
                    Icons.Filled.Settings,
                    tint = Color.Black,
                    contentDescription = "Entry Settings...",
                    modifier = Modifier.size(45.dp)
                )
                Spacer(Modifier.width(75.dp))
                Button(
                    onClick = {

                    },
                    shape = CircleShape
                ) {
                    Icon(
                        Icons.Filled.Settings,
                        tint = Color.Black,
                        contentDescription = "Entry Settings...",
                        modifier = Modifier.size(45.dp)
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row {
                Icon(
                    Icons.Filled.Close,
                    tint = Color.Black,
                    contentDescription = "Entry Settings...",
                    modifier = Modifier.size(45.dp)
                )
            }
            Spacer(Modifier.height(15.dp))
        }
    }
}