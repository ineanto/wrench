package xyz.atnrch.wrench

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import xyz.atnrch.wrench.display.WrenchDisplay
import xyz.atnrch.wrench.scheduler.FileMover

@Composable
@Preview
fun App() {
    MaterialTheme {
        val fileMover = remember { FileMover() }
        WrenchDisplay(onStartButtonClick = fileMover::start)
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Wrench") {
        App()
    }
}
