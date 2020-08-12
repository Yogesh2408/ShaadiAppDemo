package com.yogesh.shaadiassignemt.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity()
data class Id(
        @PrimaryKey(autoGenerate = true)
        val primaryId: Int,
    val name: String,
    val value: String
)