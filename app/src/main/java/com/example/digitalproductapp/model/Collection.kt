package com.example.digitalproductapp.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Data class representing a collection of items.
 *
 * @property name The name of the collection.
 * @property iconResId The resource ID of the icon associated with the collection.
 * @property items A list of items contained within the collection.
 * @property createdDate The timestamp when the collection was created, defaulting to current time.
 */
data class Collection(
    val name: String,
    val iconResId: Int,
    val items: List<String> = emptyList(),
    val createdDate: Long = System.currentTimeMillis()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(iconResId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Collection> {
        override fun createFromParcel(parcel: Parcel): Collection {
            return Collection(parcel)
        }

        override fun newArray(size: Int): Array<Collection?> {
            return arrayOfNulls(size)
        }
    }
}
