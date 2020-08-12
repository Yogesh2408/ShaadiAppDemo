package com.yogesh.shaadiassignemt.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Name(
        @PrimaryKey(autoGenerate = true)
        val primaryId: Int,
    val first: String,
    val last: String,
    val title: String
) {
    fun getFullName(): String {
        return "$title. $first $last"
    }
}