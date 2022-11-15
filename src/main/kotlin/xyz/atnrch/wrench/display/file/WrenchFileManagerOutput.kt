package xyz.atnrch.wrench.display.file

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun WrenchFileManagerInput() {
    Box(
        contentAlignment = Alignment.CenterStart,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column {
            Text("Test")
            Text("Test2")
        }
    }
}
