package com.yogesh.shaadiassignemt.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Picture(
        @PrimaryKey(autoGenerate = true)
        val primaryId: Int,
        val large: String,
        val medium: String,
        val thumbnail: String
)