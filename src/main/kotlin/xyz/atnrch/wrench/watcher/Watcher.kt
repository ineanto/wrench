package xyz.atnrch.wrench.watcher

import androidx.compose.material.SnackbarDuration
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.swing.Swing
import xyz.atnrch.wrench.compose.SnackBarDataHolder
import xyz.atnrch.wrench.logger.Logger
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

class Watcher(
    private val watcherManager: WatcherManager,
    private val snackBarDataHolder: SnackBarDataHolder
) {
    companion object {
        var WATCHING = false
    }

    private var coroutineScope = CoroutineScope(Dispatchers.Swing)

    fun start() {
        if (WATCHING) return

        coroutineScope.launch {
            WATCHING = true
            Logger.info("Started Watcher.")
            while (WATCHING) {
                move()
            }
        }
    }

    fun move() {
        snackBarDataHolder.coroutineScope.launch {
            var filesTotal = 0
            var foldersTotal = 0
            for (entry: WatcherEntry in watcherManager.getEntries().values) {
                filesTotal += 1
                entry.map.forEach {
                    val movePath = "${it.toAbsolutePath()}/${entry.file.name}"
                    println(movePath)
                    Files.copy(entry.file.toPath(), Path.of(movePath), StandardCopyOption.REPLACE_EXISTING)
                    foldersTotal += 1
                }
            }
            snackBarDataHolder.scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
            println(foldersTotal)
            if (foldersTotal < 1) {
                println(foldersTotal)
                snackBarDataHolder.scaffoldState.snackbarHostState.showSnackbar(
                    message = "No files to move, skipped.",
                    duration = SnackbarDuration.Short
                )
            } else {
                snackBarDataHolder.scaffoldState.snackbarHostState.showSnackbar(
                    message = "Successfully moved $filesTotal ${if (filesTotal > 1) "files" else "file"} to $foldersTotal different ${if (foldersTotal > 1) "folders" else "folder"}",
                    duration = SnackbarDuration.Short
                )
            }
        }
    }

    fun stop() {
        Logger.info("Stopped Watcher.")
        coroutineScope.cancel()
        coroutineScope = CoroutineScope(Dispatchers.Main)
        WATCHING = false
    }
}