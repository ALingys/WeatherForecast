package task.weatherforecast.weather.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.service.CityService;
import task.weatherforecast.weather.client.WeatherClient;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;
import task.weatherforecast.weather.pojo.WeatherSimple;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WeatherService {
    private WeatherClient weatherClient;
    private CityService cityService;

    public List<WeatherSimple> getWeather(){
        List<WeatherSimple> weatherList = new ArrayList<>();

        List<City> cityList = cityService.findAll();
        for(City city : cityList){
            WeatherRoot apiResult = weatherClient.getWeatherByCityId(city.getCityId());

            WeatherSimple weatherSimple = new WeatherSimple();
            weatherSimple.setCity(city);
            weatherSimple.setTempMin(apiResult.getMain().getTempMin());
            weatherSimple.setTempMax(apiResult.getMain().getTempMax());
            weatherSimple.setWeatherCondition(apiResult.getWeather().get(0).getDescription());

            weatherList.add(weatherSimple);
        }

        return weatherList;
    }
}
