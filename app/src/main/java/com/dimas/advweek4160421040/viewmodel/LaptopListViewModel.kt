package com.dimas.advweek4160421040.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.dimas.advweek4160421040.model.Laptop
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LaptopListViewModel(application: Application): AndroidViewModel(application) {
    val laptopLD = MutableLiveData<ArrayList<Laptop>>()
    val laptopLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue:RequestQueue? = null

    fun refresh() {
        loadingLD.value = true
        laptopLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.100.5/Laptop.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                loadingLD.value = false
                Log.d("showvoley", response)

                val sType = object : TypeToken<List<Laptop>>() {}.type
                val result = Gson().fromJson<List<Laptop>>(response, sType)
                laptopLD.value = result as ArrayList<Laptop>?
            },
            { error ->
                Log.d("showvoley", error.toString())
                laptopLoadErrorLD.value = true
                loadingLD.value = false
            })

        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}
