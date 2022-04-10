package task.weatherforecast.weather.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.service.CityService;
import task.weatherforecast.weather.client.WeatherClient;
import task.weatherforecast.weather.client.model.forecast.ForecastRoot;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;
import task.weatherforecast.weather.pojo.WeatherExtended;
import task.weatherforecast.weather.pojo.WeatherSimple;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WeatherService {
    private WeatherClient weatherClient;
    private CityService cityService;

    public List<WeatherSimple> getCitiesWeatherSimpleList(){
        List<WeatherSimple> weatherList = new ArrayList<>();

        List<City> cityList = cityService.findAll();
        for(City city : cityList){
            WeatherRoot weatherRoot = weatherClient.getWeatherByCityId(city.getCityId());
            WeatherSimple weatherSimple = new WeatherSimple(city, weatherRoot);
            weatherList.add(weatherSimple);
        }

        return weatherList;
    }

    public WeatherExtended getWeatherExtended(Long cityId, Boolean includeForecast) {
        City city = cityService.findByCityId(cityId);
        WeatherRoot weatherRoot = weatherClient.getWeatherByCityId(cityId);
        ForecastRoot forecastRoot = null;
        if(includeForecast){
            forecastRoot = weatherClient.getForecastByCityId(cityId);
        }
        WeatherExtended weatherExtended = new WeatherExtended(city, weatherRoot, forecastRoot);

        return weatherExtended;
    }

    public WeatherSimple getWeatherSimpleByCoord(Double lon, Double lat, Boolean includeForecast){
        City city = cityService.findByCoordLonAndCoordLat(lon, lat);
        WeatherRoot weatherRoot = weatherClient.getWeatherByCityId(city.getCityId());
        ForecastRoot forecastRoot = null;
        if(includeForecast){
            forecastRoot = weatherClient.getForecastByCityId(city.getCityId());
        }

        WeatherSimple weatherSimple = new WeatherSimple(city, weatherRoot, forecastRoot);

        return weatherSimple;
    }


}
