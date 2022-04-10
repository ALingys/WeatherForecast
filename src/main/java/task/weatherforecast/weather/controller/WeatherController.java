package task.weatherforecast.weather.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.weatherforecast.weather.pojo.WeatherExtended;
import task.weatherforecast.weather.pojo.WeatherSimple;
import task.weatherforecast.weather.service.WeatherService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private WeatherService weatherService;

    @GetMapping("/")
    public List<WeatherSimple> getCitiesWeatherSimpleList(){
        return weatherService.getCitiesWeatherSimpleList();
    }

    @GetMapping("/extended/{id}")
    public WeatherExtended getWeatherExtended(@PathVariable("id") Long cityId){
        return weatherService.getWeatherExtended(cityId);
    }


}
