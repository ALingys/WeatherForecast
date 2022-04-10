package task.weatherforecast.weather.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task.weatherforecast.weather.client.WeatherClient;
import task.weatherforecast.weather.client.model.forecast.ForecastRoot;
import task.weatherforecast.weather.pojo.WeatherExtended;
import task.weatherforecast.weather.pojo.WeatherSimple;
import task.weatherforecast.weather.service.WeatherService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/weather")
public class WeatherController {
    private WeatherService weatherService;
    private WeatherClient weatherClient;

    @GetMapping("/")
    public List<WeatherSimple> getCitiesWeatherSimpleList(){
        return weatherService.getCitiesWeatherSimpleList();
    }

    @GetMapping("/extended/{id}/")
    public WeatherExtended getWeatherExtended(@PathVariable("id") Long cityId,
                                              @RequestParam(name = "includeForecast", defaultValue = "false")
                                              Boolean includeForecast){
        return weatherService.getWeatherExtended(cityId, includeForecast);
    }

    @GetMapping("/forecast/{id}")
    public ForecastRoot getForecast(@PathVariable("id") Long cityId){
        return weatherClient.getForecastByCityId(cityId);
    }


}
