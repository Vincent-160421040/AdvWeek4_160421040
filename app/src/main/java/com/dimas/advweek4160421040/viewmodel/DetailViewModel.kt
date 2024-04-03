package com.dimas.advweek4160421040.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dimas.advweek4160421040.model.Laptop
import com.dimas.advweek4160421040.model.Student

class DetailViewModel: ViewModel() {
    val studentLD = MutableLiveData<Student>()
    val laptopLD = MutableLiveData<Laptop>()

    fun fetch(){
        val student1 = Student("160421040", "Vincentsius", "2002/03/15",
            "08115999393", "https://t4.ftcdn.net/jpg/02/45/56/35/360_F_245563558_XH9Pe5LJI2kr7VQuzQKAjAbz9PAyejG1.jpg")

        studentLD.value = student1
    }
}