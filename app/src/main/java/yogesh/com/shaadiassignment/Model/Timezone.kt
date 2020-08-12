package com.yogesh.shaadiassignemt.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Timezone(
        @PrimaryKey(autoGenerate = true)
        val primaryId: Int,
        val description: String,
        val offset: String
)