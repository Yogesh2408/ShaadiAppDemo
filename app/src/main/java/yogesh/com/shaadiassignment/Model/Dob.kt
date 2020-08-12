package com.yogesh.shaadiassignemt.dataclasses

import android.util.Log
import androidx.room.Entity
import androidx.room.PrimaryKey
import yogesh.com.shaadiassignment.Utils
import java.text.SimpleDateFormat
import java.util.*

@Entity()
data class Dob(
        @PrimaryKey(autoGenerate = true)
        val primaryId: Int,
        val age: Int,
        val date: String
) {
    fun getAgeAndDob(): String {
        val formattedDate = Utils.getFormattedDate(date)
        return "Age: $age, DOB: $formattedDate"
    }

}