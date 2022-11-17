package xyz.atnrch.wrench.scaffold

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.colors.WrenchColors
import xyz.atnrch.wrench.components.FilePicker
import xyz.atnrch.wrench.components.WrenchFileManagerInput
import xyz.atnrch.wrench.components.WrenchFileManagerOutput
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.watcher.Watcher

@Composable
fun WrenchScaffold() {
    val watcher = remember { Watcher() }
    var status by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
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
        },
        floatingActionButton = {
            //.............
            // ADD BUTTON (FLOATING)
            //.............
            FloatingActionButton(
                {
                    FilePicker({
                        Logger.info("Path: ${it.absolutePath}")
                    }, {
                        Logger.info("No file selected.")
                    })
                },
                backgroundColor = WrenchColors.LIGHT,
            ) {
                Icon(
                    Icons.Filled.Add,
                    tint = Color.White,
                    contentDescription = "Add file...",
                    modifier = Modifier.size(28.dp)
                )
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                ),
                backgroundColor = WrenchColors.PRIMARY
            ) {
                //.............
                // START BUTTON
                //.............
                Spacer(Modifier.width(5.dp))
                Button(
                    {
                        status = if (status) {
                            run { watcher.stop() }
                            false
                        } else {
                            run { watcher.start() }
                            true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(WrenchColors.LIGHT, Color.White),
                    contentPadding = ButtonDefaults.ContentPadding,
                    shape = RoundedCornerShape(100),
                    modifier = Modifier.shadow(15.dp, RoundedCornerShape(100), false)
                ) {
                    if (status) Icon(
                        Icons.Filled.Close,
                        contentDescription = "Stop",
                        modifier = Modifier.size(28.dp)
                    ) else Icon(
                        Icons.Filled.PlayArrow,
                        tint = Color.White,
                        contentDescription = "Start",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }
    ) {
        WrenchFileManagerInput()
        WrenchFileManagerOutput()
    }

}