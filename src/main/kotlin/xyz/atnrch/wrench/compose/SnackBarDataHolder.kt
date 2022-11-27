package xyz.atnrch.wrench.compose

import androidx.compose.material.ScaffoldState
import kotlinx.coroutines.CoroutineScope

data class SnackBarDataHolder(val scaffoldState: ScaffoldState, val coroutineScope: CoroutineScope)