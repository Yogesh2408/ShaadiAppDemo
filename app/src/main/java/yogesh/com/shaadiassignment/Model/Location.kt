package com.yogesh.shaadiassignemt.dataclasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Location(
        @PrimaryKey(autoGenerate = true)
        val primaryId: Int,
        val city: String,
        val coordinates: Coordinates,
        val country: String,
        val postcode: Any,
        val state: String,
        val street: Street,
        val timezone: Timezone
) {
    fun getAddress(): String {
        return "${street.name}, ${street.number}, $city-$postcode\n $state, $country"
    }
}