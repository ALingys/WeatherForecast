package task.weatherforecast.weather.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.service.CityService;
import task.weatherforecast.weather.client.WeatherClient;
import task.weatherforecast.weather.client.model.forecast.ForecastRoot;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;
import task.weatherforecast.weather.data.Forecast;
import task.weatherforecast.weather.data.WeatherExtended;
import task.weatherforecast.weather.data.WeatherSimple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class WeatherService {
    private final WeatherClient weatherClient;
    private final CityService cityService;

    private List<Forecast> getForecastList(ForecastRoot forecastRoot){
        java.util.List<task.weatherforecast.weather.client.model.forecast.List> list = forecastRoot.getList();
        return list.stream()
                .map(item -> Forecast.builder()
                        .dt(item.getDt())
                        .dtTxt(item.getDtTxt())
                        .temp(item.getMain().getTemp())
                        .tempMin(item.getMain().getTempMin())
                        .tempMax(item.getMain().getTempMax())
                        .humidity(item.getMain().getHumidity())
                        .pressure(item.getMain().getHumidity())
                        .weatherCondition(item.getWeather().get(0).getDescription())
                        .build()).collect(Collectors.toList());
    }

    public List<WeatherSimple> getCitiesWeatherSimpleList(Long population, Double areaFrom, Double areaTo){
        List<City> cityList;
        if(population!=null){
            cityList = cityService.findAllByPopulation(population);
        } else if(areaFrom!=null && areaTo!=null){
            cityList = cityService.findAllByAreaBetween(areaFrom, areaTo);
        } else {
            cityList = cityService.findAll();
        }

        return cityList.stream()
                .map(city -> new WeatherSimple(city, weatherClient.getWeatherByCityId(city.getCityId())))
                .collect(Collectors.toList());
    }

    public WeatherExtended getWeatherExtended(Long cityId, Boolean includeForecast) {
        City city = cityService.findByCityId(cityId);
        WeatherRoot weatherRoot = weatherClient.getWeatherByCityId(cityId);

        List<Forecast> forecastList = null;
        if(includeForecast){
            ForecastRoot forecastRoot = weatherClient.getForecastByCityId(city.getCityId());
            forecastList = getForecastList(forecastRoot);
        }

        return new WeatherExtended(city, weatherRoot, forecastList);
    }

    public WeatherSimple getWeatherSimpleByCoord(Double lon, Double lat, Boolean includeForecast){
        City city = cityService.findByCoordLonAndCoordLat(lon, lat);
        WeatherRoot weatherRoot = weatherClient.getWeatherByCityId(city.getCityId());

        List<Forecast> forecastList = null;
        if(includeForecast){
            ForecastRoot forecastRoot = weatherClient.getForecastByCityId(city.getCityId());
            forecastList = getForecastList(forecastRoot);
        }

        return new WeatherSimple(city, weatherRoot, forecastList);
    }
}
