package xyz.atnrch.wrench

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import xyz.atnrch.wrench.gui.WrenchScaffold
import xyz.atnrch.wrench.logger.Logger
import java.io.File
import java.nio.file.Paths
import javax.swing.UIManager

class Wrench {
    companion object {
        const val PREFIX: String = "(Wrench)"
        private val ROOT_FOLDER_PATH = System.getProperty("user.dir") + File.separator + "WrenchData"
        private val SERVER_FOLDER_PATH = ROOT_FOLDER_PATH + File.separator + "servers"
        val ROOT_FOLDER: File = Paths.get(ROOT_FOLDER_PATH).toFile()
        val SERVER_FOLDER: File = Paths.get(SERVER_FOLDER_PATH).toFile()

        @JvmStatic
        fun main(args: Array<String>) = application {
            val state = rememberWindowState(width = 1000.dp, height = 1024.dp)
            Window(
                state = state,
                onCloseRequest = {
                    // For debug purposes, clean the server folder on exit
                    SERVER_FOLDER.listFiles()?.forEach { it.delete() }
                    SERVER_FOLDER.delete()
                    exitApplication()
                }
            ) {
                Logger.info("Starting Wrench...")

                Logger.info("Creating folders...")
                ROOT_FOLDER.mkdir()
                SERVER_FOLDER.mkdir()

                Logger.info("Root folder location: $ROOT_FOLDER")
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
                MaterialTheme { WrenchScaffold(state) }
            }
        }
    }
}