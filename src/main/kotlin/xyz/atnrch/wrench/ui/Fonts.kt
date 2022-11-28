package xyz.atnrch.wrench.ui

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font

class Fonts {
    companion object {
        val JOST_MEDIUM: FontFamily = FontFamily(
            Font(
                resource = "font/Jost-Medium.ttf",
                style = FontStyle.Normal,
                weight = FontWeight.Medium
            )
        )

        val ROBOTO_MEDIUM: FontFamily = FontFamily(
            Font(
                resource = "font/Roboto-Medium.ttf",
                style = FontStyle.Normal,
                weight = FontWeight.Medium
            )
        )

        val ROBOTO_REGULAR: FontFamily = FontFamily(
            Font(
                resource = "font/Roboto-Regular.ttf",
                style = FontStyle.Normal,
                weight = FontWeight.Medium
            )
        )

        val ROBOTO_BOLD: FontFamily = FontFamily(
            Font(
                resource = "font/Roboto-Bold.ttf",
                style = FontStyle.Normal,
                weight = FontWeight.Medium
            )
        )
    }
}