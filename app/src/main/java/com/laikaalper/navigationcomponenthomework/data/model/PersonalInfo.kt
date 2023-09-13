package com.laikaalper.navigationcomponenthomework.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonalInfo(  val name: String,
                          val email: String,
                          val phone: String):Parcelable
