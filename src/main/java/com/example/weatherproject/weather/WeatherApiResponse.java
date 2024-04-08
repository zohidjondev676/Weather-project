package com.example.weatherproject.weather;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class WeatherApiResponse {
    private String temperature;
    private String humidity;
    private String windSpeed;


}
