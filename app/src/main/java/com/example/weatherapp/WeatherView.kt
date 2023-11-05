package com.example.weatherapp

interface WeatherView {

    fun showWeather(model: WeatherModel)
    fun showError(error:String)
    fun showDate(date:String)

}