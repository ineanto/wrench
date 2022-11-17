package xyz.atnrch.wrench

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import xyz.atnrch.wrench.logger.Logger
import xyz.atnrch.wrench.scaffold.WrenchScaffold
import xyz.atnrch.wrench.watcher.Watcher
import javax.swing.UIManager

class WrenchApp {
    companion object {
        const val PREFIX: String = "(Wrench)"

        @JvmStatic
        fun main(args: Array<String>) {
            application {
                Window(onCloseRequest = {
                    Logger.info("Stopping Wrench...")
                    Logger.info("bye!")
                    ::exitApplication.invoke()
                }, title = "Wrench") {
                    Logger.info("Starting Wrench...")
                    App()
                }
            }
        }

        @Composable
        @Preview
        @JvmStatic
        fun App() {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
            MaterialTheme {
                val watcher = remember { Watcher() }
                WrenchScaffold(
                    onStartButtonClick = watcher::start,
                    onStopButtonClick = watcher::stop,
                    onAddButtonClick = {}
                )
            }
        }
    }
}