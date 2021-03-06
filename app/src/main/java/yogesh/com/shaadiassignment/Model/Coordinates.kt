package com.yogesh.shaadiassignemt.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Coordinates(
        @PrimaryKey(autoGenerate = true)
        val primaryId: Int,
        val latitude: String,
        val longitude: String
)