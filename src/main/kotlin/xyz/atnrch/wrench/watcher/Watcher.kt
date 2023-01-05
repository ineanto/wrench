package xyz.atnrch.wrench.watcher

import androidx.compose.material.SnackbarDuration
import kotlinx.coroutines.launch
import xyz.atnrch.wrench.compose.SnackBarDataHolder
import xyz.atnrch.wrench.logger.Logger
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption
import kotlin.io.path.name

class Watcher(
    private val watcherManager: WatcherManager,
    private val snackBarDataHolder: SnackBarDataHolder
) {
    fun move() {
        Logger.info("Moving files...")
        snackBarDataHolder.coroutineScope.launch {
            var filesTotal = 0
            var foldersTotal = 0
            for (entry: WatcherEntry in watcherManager.getEntries().values) {
                filesTotal += 1
                entry.outputs.forEach {
                    val movePath = "${it.toAbsolutePath()}/${entry.file.name}"
                    try {
                        Files.copy(entry.file.toPath(), Path.of(movePath), StandardCopyOption.REPLACE_EXISTING)
                        foldersTotal += 1
                    } catch (exception: IOException) {
                       Logger.warn("Failed to move ${it.name} to $movePath! (${exception.message}")
                    }
                }
            }
            val logMessage: String = if (foldersTotal < 1) {
                "No files to move!"
            } else {
                "Successfully moved $filesTotal ${if (filesTotal > 1) "files" else "file"} to $foldersTotal different ${if (foldersTotal > 1) "folders" else "folder"}."
            }
            Logger.info(logMessage)
            Logger.info("Done moving files.")
            snackBarDataHolder.scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
            snackBarDataHolder.scaffoldState.snackbarHostState.showSnackbar(
                message = logMessage,
                duration = SnackbarDuration.Short
            )
        }
    }
}