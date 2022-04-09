package task.weatherforecast.weather.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.weatherforecast.weather.client.WeatherClient;
import task.weatherforecast.weather.client.model.WeatherRoot;

@RestController
@RequestMapping("/api/weather")
@AllArgsConstructor
public class WeatherController {
    private WeatherClient weatherClient;

    @GetMapping("/")
    public WeatherRoot getWeather(){
        return weatherClient.getWeatherByCityId(1L);
    }
}
