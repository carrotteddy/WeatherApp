package com.example.weatherapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Calendar
import javax.inject.Inject

class Presenter @Inject constructor(private val api: WeatherApi) {

    lateinit var view: WeatherView

    fun attachView(view: WeatherView){
        this.view = view
    }

    fun getWeather(city:String = "Bishkek"){
        api.getWeather(city).enqueue(object: Callback<WeatherModel>{
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                response.body()?.let {
                    view.showWeather(it)
                    view.showDate(getDate())
                }
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                view.showError(t.message.toString())
            }

        })
    }

    fun getDate(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd MMMM")
        return dateFormat.format(calendar.time)
    }


}