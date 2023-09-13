package com.laikaalper.navigationcomponenthomework.data.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CustomInfo(
                      val personalInfo: PersonalInfo,
                      val question1: String,
                      val question2: String,
                      val question3: String
) : Parcelable
