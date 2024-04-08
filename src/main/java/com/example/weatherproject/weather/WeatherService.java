package com.example.weatherproject.weather;

import com.example.weatherproject.weather.entity.Weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    private  final  String apiKey="143935f743a3446caed123538232610";
    private RestTemplate restTemplate = new RestTemplate();

    public Weather getWeather(String city) {
        String url = "https://www.weatherapi.com/my" + apiKey + "&q=" + city;

        HttpClient build = HttpClient.newBuilder().build();
        try {
            HttpResponse<String> send = build.send(HttpRequest.newBuilder().GET().uri(new URI(url)).build(), HttpResponse.BodyHandlers.ofString());
            System.out.println(send.body());

        } catch (IOException ignored) {

        } catch (InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        WeatherApiResponse response = restTemplate.getForObject(url,WeatherApiResponse.class);

        System.out.println("response = " + response);
        Weather weather = new Weather();
        weather.setTemperature(response.getTemperature());
        weather.setHumidity(response.getHumidity());
        weather.setWindSpeed(response.getWindSpeed());


        return weather;
    }
}