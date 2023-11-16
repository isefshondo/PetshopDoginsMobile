package com.example.petshopdoginsmobile.ui.components.buttons

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import com.example.petshopdoginsmobile.ui.theme.VibrantBlue
import com.example.petshopdoginsmobile.ui.theme.linkMedium12

@Composable
fun ClickableLinkText(text: String, onClick: () -> Unit) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append(text)
        }
    }

    ClickableText(
        text = annotatedString,
        style = linkMedium12.copy(VibrantBlue),
        onClick = { offset ->
            val annotation = annotatedString.getStringAnnotations(
                tag = "URL",
                start = offset,
                end = offset
            ).firstOrNull()

            if(annotation != null) {
                onClick()
            }
        }
    )
}
