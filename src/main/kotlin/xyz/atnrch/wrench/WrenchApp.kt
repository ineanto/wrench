package xyz.atnrch.wrench

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import xyz.atnrch.wrench.gui.WrenchScaffold
import xyz.atnrch.wrench.logger.Logger
import java.nio.file.Paths
import javax.swing.UIManager

class WrenchApp {
    companion object {
        const val PREFIX: String = "(Wrench)"

        @JvmStatic
        fun main(args: Array<String>) = application {
            val state = rememberWindowState(width = 1000.dp, height = 1024.dp)
            Window(
                state = state,
                onCloseRequest = ::exitApplication
            ) {
                Logger.info("Starting Wrench...")
                Logger.info("Working Directory: ${Paths.get("").toAbsolutePath()}")
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
                MaterialTheme { WrenchScaffold(state) }
            }
        }
    }
}