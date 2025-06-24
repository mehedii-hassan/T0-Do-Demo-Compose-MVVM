package com.example.tododemocompose.data.models

import androidx.compose.ui.graphics.Color
import com.example.tododemocompose.ui.theme.HighPriorityColor
import com.example.tododemocompose.ui.theme.LowPriorityColor
import com.example.tododemocompose.ui.theme.MediumPriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(Color.Transparent)
}