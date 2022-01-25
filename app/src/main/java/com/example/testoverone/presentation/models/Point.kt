package com.example.testoverone.presentation.models

import java.io.Serializable

data class Point(
    val id: Int,
    val lat: Double,
    val lan: Double,
    val isChecked: Boolean = false
) : Serializable {
//     constructor(parcel: Parcel) : this(
//         parcel.readInt(),
//         parcel.readDouble(),
//         parcel.readDouble()
//     ) {
//     }
//
//     override fun describeContents(): Int {
//         return 0
//     }
//
//     override fun writeToParcel(dest: Parcel?, flags: Int) {
//         dest?.writeInt(id)
//         dest?.writeDouble(lat)
//         dest?.writeDouble(lan)
//     }
//
//     companion object CREATOR : Parcelable.Creator<Point> {
//         override fun createFromParcel(parcel: Parcel): Point {
//             return Point(parcel)
//         }
//
//         override fun newArray(size: Int): Array<Point?> {
//             return arrayOfNulls(size)
//         }
//     }
}