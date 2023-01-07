package xyz.atnrch.wrench.gui.filemanager.center

import java.io.File
import javax.swing.JFileChooser

fun showFilePicker(
    onResult: (file: File) -> Unit,
    onNoResult: () -> Unit
) {
    val filePicker = JFileChooser(System.getProperty("user.home")).apply {
        fileSelectionMode = JFileChooser.FILES_ONLY
        dialogTitle = "Select a file"
        approveButtonText = "Confirm"
        approveButtonToolTipText = "Select source file"
    }
    filePicker.showOpenDialog(null)
    if (filePicker.selectedFile != null) onResult.invoke(filePicker.selectedFile) else onNoResult.invoke()
}

fun showDirectoryPicker(
    onResult: (file: File) -> Unit,
    onNoResult: () -> Unit
) {
    val filePicker = JFileChooser(System.getProperty("user.home")).apply {
        fileSelectionMode = JFileChooser.DIRECTORIES_ONLY
        dialogTitle = "Select a directory"
        approveButtonText = "Confirm"
        approveButtonToolTipText = "Select output directory"
    }
    filePicker.showOpenDialog(null)
    if (filePicker.selectedFile != null) onResult.invoke(filePicker.selectedFile) else onNoResult.invoke()
}