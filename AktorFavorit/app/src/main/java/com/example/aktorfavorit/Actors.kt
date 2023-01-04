package com.example.aktorfavorit

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class Actors(

    var name : String = "",
    var birth : String = "",
    var movies : String = "",
    var detail : String = "",
    var photo : Int = 0,

) : Parcelable
