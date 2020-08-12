package com.yogesh.shaadiassignemt.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table")
data class Result(
        val cell: String,
        val dob: Dob,
        @PrimaryKey()
        val email: String,
        val gender: String,
        val id: Id,
        val location: Location,
        val login: Login,
        val name: Name,
        val nat: String,
        val phone: String,
        val picture: Picture,
        val registered: Registered,
        val extraInfo: String?
)