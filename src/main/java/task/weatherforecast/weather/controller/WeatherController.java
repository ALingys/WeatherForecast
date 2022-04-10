package task.weatherforecast.weather.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.weatherforecast.weather.pojo.WeatherSimple;
import task.weatherforecast.weather.service.WeatherService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private WeatherService weatherService;

    @GetMapping("/")
    public List<WeatherSimple> getWeather(){
        return weatherService.getWeather();
    }
}
