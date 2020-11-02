package com.example.assigment2.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anggota (
    var nama: String? = null,
    var foto: Int? = null,
    var alamat: String? = null
) : Parcelable