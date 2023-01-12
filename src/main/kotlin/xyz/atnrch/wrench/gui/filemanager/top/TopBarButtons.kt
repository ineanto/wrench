package xyz.atnrch.wrench.gui.filemanager.top

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.json.JsonLayout
import xyz.atnrch.wrench.json.SerializedWatcherEntry
import xyz.atnrch.wrench.watcher.WatcherEntry
import xyz.atnrch.wrench.watcher.WatcherManager

@Composable
fun TopBarButtons(
    jsonLayout: JsonLayout,
    values: MutableCollection<WatcherEntry>
) {
    Button(onClick = {
        jsonLayout.writeLayout(SerializedWatcherEntry.fromUnserializedEntries(values.toList()))
    }) {
        Text("Save")
    }
    Spacer(Modifier.width(10.dp))
    Button(onClick = {
        values.clear()
        // not the cleanest way of doing things
        // but tbh I'm tired after working on serialization
        // for the past 2 hrs
        // TODO: Make it cleaner maybe?
        WatcherManager.CURRENT_ID = 0
        jsonLayout.readLayout()
    }) {
        Text("Load")
    }
    Spacer(Modifier.width(10.dp))
}