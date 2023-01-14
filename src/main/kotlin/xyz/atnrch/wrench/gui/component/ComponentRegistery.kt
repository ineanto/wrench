package xyz.atnrch.wrench.gui.component

import androidx.compose.runtime.Composable

val REGISTRY: HashMap<Int, @Composable () -> Unit> = hashMapOf()
var ACTIVE_COMPOSABLE = -1

@Composable
fun RegisterComposable(id: Int, composable: @Composable () -> Unit) {
    REGISTRY[id] = composable
    composable.invoke()
}

@Composable
fun GetActiveComposable(): Int {
    return ACTIVE_COMPOSABLE
}