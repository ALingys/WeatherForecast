package task.weatherforecast.weather.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task.weatherforecast.weather.data.WeatherExtended;
import task.weatherforecast.weather.data.WeatherSimple;
import task.weatherforecast.weather.service.WeatherService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/weather")
public class WeatherController {
    private WeatherService weatherService;

    @GetMapping("/")
    public List<WeatherSimple> getCitiesWeatherSimpleList(
            @RequestParam(name = "cityPopulation", required = false) Long population,
            @RequestParam(name = "cityAreaFrom", required = false) Double areaFrom,
            @RequestParam(name = "cityAreaTo", required = false) Double areaTo){
        return weatherService.getCitiesWeatherSimpleList(population, areaFrom, areaTo) ;
    }

    @GetMapping("/extended/{id}")
    public WeatherExtended getWeatherExtended(@PathVariable("id") Long cityId,
                                              @RequestParam(name = "includeForecast", defaultValue = "false")
                                              Boolean includeForecast){
        return weatherService.getWeatherExtended(cityId, includeForecast);
    }

    @RequestMapping(value = "/coord/", method = RequestMethod.GET)
    public WeatherSimple findByCoordLonAndCoordLat(@RequestParam(name = "lat") Double lat,
                                                   @RequestParam(name = "lon") Double lon,
                                                   @RequestParam(name = "includeForecast", defaultValue = "false")
                                                   Boolean includeForecast){
        return weatherService.getWeatherSimpleByCoord(lat, lon, includeForecast);
    }
}
