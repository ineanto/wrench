package xyz.atnrch.wrench.gui.server.center

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import xyz.atnrch.wrench.gui.appearance.Fonts
import xyz.atnrch.wrench.gui.appearance.UIColors

@Composable
fun ServerList() {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(UIColors.PRIMARY)
            .padding(10.dp)
    ) {
        val stateVertical = rememberScrollState(0)

        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(stateVertical)
                .padding(end = 12.dp, bottom = 12.dp)
        ) {
            Column {
                for (item in 0..5) {
                    Text(
                        text = "SERVER $item",
                        fontSize = TextUnit(20F, TextUnitType.Sp),
                        fontFamily = Fonts.ROBOTO_BOLD,
                        color = Color.White
                    )
                    if (item < 5) {
                        Spacer(modifier = Modifier.height(50.dp))
                    }
                }
            }
        }
        VerticalScrollbar(
            modifier = Modifier.align(Alignment.CenterEnd)
                .fillMaxHeight(),
            adapter = rememberScrollbarAdapter(stateVertical)
        )
    }
}