package xyz.atnrch.wrench.scaffold

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.awt.ComposeWindow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.colors.WrenchColors
import xyz.atnrch.wrench.components.WrenchFileManagerInput
import xyz.atnrch.wrench.components.WrenchFileManagerOutput
import javax.swing.JFileChooser

@Composable
fun WrenchScaffold(
    onStartButtonClick: () -> Unit,
    onStopButtonClick: () -> Unit,
    onAddButtonClick: () -> Unit
) {
    var status by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = WrenchColors.PRIMARY,
                contentColor = Color.White,
                elevation = 16.dp,
                title = { Text("Wrench") },
                actions = {
                    Button(
                        onClick = {
                            val fileChooser = JFileChooser(System.getProperty("user.home")).apply {
                                fileSelectionMode = JFileChooser.FILES_ONLY
                                dialogTitle = "Select a file"
                                approveButtonText = "Select"
                                approveButtonToolTipText = "Select current directory as save destination"
                            }
                            fileChooser.showOpenDialog(ComposeWindow())
                            val result = fileChooser.selectedFile
                            println(result)
                        }
                    ) {
                        Text("DEBUG")
                    }
                })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* ... */ },
                backgroundColor = WrenchColors.LIGHT
            ) {
                Icon(
                    Icons.Filled.Add,
                    tint = Color.White,
                    contentDescription = "Start",
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
                Spacer(Modifier.width(5.dp))
                Button(
                    {
                        status = if (status) {
                            onStopButtonClick.invoke()
                            false
                        } else {
                            onStartButtonClick.invoke()
                            true
                        }
                    },
                    colors = ButtonDefaults.buttonColors(WrenchColors.LIGHT, Color.White),
                    contentPadding = ButtonDefaults.ContentPadding
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