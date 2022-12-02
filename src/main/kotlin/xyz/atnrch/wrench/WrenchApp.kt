package xyz.atnrch.wrench

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.window.singleWindowApplication
import xyz.atnrch.wrench.components.WrenchScaffold
import xyz.atnrch.wrench.logger.Logger
import javax.swing.UIManager

class WrenchApp {
    companion object {
        const val PREFIX: String = "(Wrench)"

        @JvmStatic
        fun main(args: Array<String>) = singleWindowApplication {
            Logger.info("Starting Wrench...")
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName())
            MaterialTheme { WrenchScaffold() }
        }
    }
}