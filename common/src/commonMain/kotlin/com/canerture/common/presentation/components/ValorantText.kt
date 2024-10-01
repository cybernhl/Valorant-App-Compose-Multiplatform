package com.canerture.common.presentation.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
public fun ValorantText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle,
) {
    Text(
        modifier = modifier,
        text = text,
        style = style
    )
}
