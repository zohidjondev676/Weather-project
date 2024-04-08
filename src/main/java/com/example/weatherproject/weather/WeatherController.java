package com.example.weatherproject.weather;

import com.example.weatherproject.weather.entity.Weather;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class WeatherController {

    private WeatherService weatherService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        Weather weather = weatherService.getWeather(city);
        model.addAttribute("weather", weather);
        return "weather";
    }
}