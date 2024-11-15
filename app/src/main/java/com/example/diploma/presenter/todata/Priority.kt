package com.example.diploma.presenter.todata

import androidx.compose.ui.graphics.Color
import com.example.diploma.ui.theme.*


enum class Priority(val color: Color) {
    HIGH(errorLight),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(backgroundLight)
}