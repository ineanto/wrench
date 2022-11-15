package xyz.atnrch.wrench

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import xyz.atnrch.wrench.display.WrenchDisplay
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.scheduler.Watcher

@Composable
@Preview
fun App() {
    MaterialTheme {
        val watcher = remember { Watcher() }
        WrenchDisplay(
            onStartButtonClick = watcher::start,
            onStopButtonClick = watcher::stop,
            onAddButtonClick = {}
        )
    }
}

fun main() = application {
    Window(onCloseRequest = {
        Logger.info("Stopping Wrench...")
        Logger.info("bye!")
        ::exitApplication.invoke()
    }, title = "Wrench") {
        Logger.info("Starting Wrench...")
        App()
    }
}
