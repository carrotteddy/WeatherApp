package com.example.weatherapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), WeatherView {

    private lateinit var  binding: ActivityMainBinding
    @Inject
    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        presenter.getWeather()
    }

    override fun showWeather(model: WeatherModel) {
        binding.tvUnits.text = "${model.main.temp}${getString(R.string.c)}"
        binding.tvCity.text = model.name
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showDate(date: String) {
        binding.tvDate.text = date
    }
}