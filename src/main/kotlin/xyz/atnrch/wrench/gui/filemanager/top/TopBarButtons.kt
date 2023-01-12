package xyz.atnrch.wrench.gui.filemanager.top

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.json.JsonConfig
import xyz.atnrch.wrench.watcher.WatcherEntry

@Composable
fun TopBarButtons(
    jsonConfig: JsonConfig,
    values: MutableCollection<WatcherEntry>
) {
    Button(onClick = {
        println(values.toList().joinToString(","))
        jsonConfig.writeLayout(values.toList())
    }) {
        Text("Save")
    }
    Spacer(Modifier.width(10.dp))
    Button(onClick = {
        jsonConfig.readLayout()
    }) {
        Text("Load")
    }
    Spacer(Modifier.width(10.dp))
}