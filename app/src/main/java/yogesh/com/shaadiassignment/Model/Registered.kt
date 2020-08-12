package com.yogesh.shaadiassignemt.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey
import yogesh.com.shaadiassignment.Utils

@Entity()
data class Registered(
        @PrimaryKey(autoGenerate = true)
        val primaryId: Int,
        val age: Int,
        val date: String
) {
    fun getRegDate(): String {
        return Utils.getFormattedDate(date)
    }

}