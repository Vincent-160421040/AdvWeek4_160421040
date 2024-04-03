package com.dimas.advweek4160421040.model

import com.google.gson.annotations.SerializedName

data class Student(
    val id:String?,
    @SerializedName("student_name") val name:String?,
    @SerializedName("birth_of_date") val dob:String?,
    val phone:String?,
    @SerializedName("photo_url") val photoUrl:String
)

data class Specs(
    val screen_size: Double,
    val resolution: String,
    val graphics_card: String,
    val operating_system: String
)

data class Laptop(
    val id: Int,
    val brand: String,
    val model: String,
    val processor: String,
    val ram_gb: Int,
    val storage_gb: Int,
    val features: List<String>,
    val specs: Specs,
    val images: String
)

