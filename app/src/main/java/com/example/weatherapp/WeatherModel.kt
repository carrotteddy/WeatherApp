package com.example.weatherapp

data class WeatherModel(
    val weather: List<WeatherDescriptionModel>,
    val main: MainModel,
    val wind: WindModel,
    val sys: SysModel,
    val name: String

)

data class SysModel (
    val country: String
)



data class WindModel (
    val speed: Double
)



data class MainModel (
    val temp: Double
)

data class WeatherDescriptionModel (
    val description: String
)

