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

        val JOST_BOLD: FontFamily = FontFamily(
            Font(
                resource = "font/Jost-Bold.ttf",
                style = FontStyle.Normal,
                weight = FontWeight.Bold
            )
        )

        val JOST_MEDIUM_ITALIC: FontFamily = FontFamily(
            Font(
                resource = "font/Jost-MediumItalic.ttf",
                style = FontStyle.Italic,
                weight = FontWeight.Medium
            )
        )

        val JOST_LIGHT_ITALIC: FontFamily = FontFamily(
            Font(
                resource = "font/Jost-LightItalic.ttf",
                style = FontStyle.Italic,
                weight = FontWeight.Light
            )
        )
    }
}