package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Topic(
    @StringRes val name: Int,
    val availableCourses: Int,
    @DrawableRes val imaRes: Int
) {}