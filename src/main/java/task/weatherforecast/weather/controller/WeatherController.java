package task.weatherforecast.weather.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.weatherforecast.weather.pojo.Weather;
import task.weatherforecast.weather.service.WeatherService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/weather")
@AllArgsConstructor
public class WeatherController {
    private WeatherService weatherService;

    @GetMapping("/")
    public Weather getWeather(){
        Weather weather = new Weather();
        weather.setTemperature(new BigDecimal(3));
        return weather;
    }
}
