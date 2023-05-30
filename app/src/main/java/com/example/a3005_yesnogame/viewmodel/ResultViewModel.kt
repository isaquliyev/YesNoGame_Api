package com.example.a3005_yesnogame.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a3005_yesnogame.network.RetrofitClient
import com.example.a3005_yesnogame.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultViewModel : ViewModel() {
    private var resultLiveData = MutableLiveData<Result>()
    fun getResult() {
        RetrofitClient.api.getResult().enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                if (response.body() != null) {
                    resultLiveData.value = response.body()!!
                } else {
                    return
                }
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                Log.d("TAG", t.message.toString())
            }
        }
        )
    }
    fun observeAnswerLiveData() : LiveData<Result> {
        return resultLiveData
    }
}