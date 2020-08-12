package com.yogesh.shaadiassignemt.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "login_table")
data class Login(
        val md5: String,
        val password: String,
        val salt: String,
        val sha1: String,
        val sha256: String,
        val username: String,
        @PrimaryKey()
        val uuid: String
)