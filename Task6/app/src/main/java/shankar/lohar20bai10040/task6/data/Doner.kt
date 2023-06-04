package shankar.lohar20bai10040.task6.data

import android.os.Parcel
import android.os.Parcelable

data class Doner(
    val name: String?,
    val age: String?,
    val bloogGroup:String?,
    val phone:String?
    ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(age)
        parcel.writeString(bloogGroup)
        parcel.writeString(phone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Doner> {
        override fun createFromParcel(parcel: Parcel): Doner {
            return Doner(parcel)
        }

        override fun newArray(size: Int): Array<Doner?> {
            return arrayOfNulls(size)
        }
    }
}
