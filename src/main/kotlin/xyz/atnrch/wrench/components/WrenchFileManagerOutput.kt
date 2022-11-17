package xyz.atnrch.wrench.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WrenchFileManagerOutput() {
    Box(
        contentAlignment = Alignment.CenterEnd,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(96.dp)
        ) {
            val backgroundColor = remember { mutableStateOf(Color.Black) }

            Text(
                text = "Test",
                color = backgroundColor.value,
                modifier = Modifier.clickable {
                    println("Click!")
                     backgroundColor.value = Color.Red
                }
            )
            Text("Test2")
        }
    }
}
