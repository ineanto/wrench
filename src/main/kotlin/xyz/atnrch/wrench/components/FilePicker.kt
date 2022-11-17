package xyz.atnrch.wrench.components

import androidx.compose.ui.awt.ComposeWindow
import java.io.File
import javax.swing.JFileChooser

fun FilePicker(
    onResult: (file: File) -> Unit,
    onNoResult: () -> Unit
) {
    val filePicker = JFileChooser(System.getProperty("user.home")).apply {
        fileSelectionMode = JFileChooser.FILES_ONLY
        dialogTitle = "Select a file"
        approveButtonText = "Confirm"
        approveButtonToolTipText = "Select source file"
    }
    filePicker.showOpenDialog(ComposeWindow())
    if (filePicker.selectedFile != null) onResult.invoke(filePicker.selectedFile) else onNoResult.invoke()
}