package task.weatherforecast.weather.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.service.CityService;
import task.weatherforecast.weather.client.WeatherClient;
import task.weatherforecast.weather.client.model.forecast.ForecastRoot;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;
import task.weatherforecast.weather.pojo.Forecast;
import task.weatherforecast.weather.pojo.WeatherExtended;
import task.weatherforecast.weather.pojo.WeatherSimple;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class WeatherService {
    private WeatherClient weatherClient;
    private CityService cityService;

    private List<Forecast> buildForecastList(ForecastRoot forecastRoot){
        List<Forecast> result = new ArrayList<>();

        java.util.List<task.weatherforecast.weather.client.model.forecast.List> list = forecastRoot.getList();
        for(task.weatherforecast.weather.client.model.forecast.List item : list){
            Forecast forecast = new Forecast();
            forecast.setDt(item.getDt());
            forecast.setDtTxt(item.getDtTxt());
            forecast.setTemp(item.getMain().getTemp());
            forecast.setTempMin(item.getMain().getTempMin());
            forecast.setTempMax(item.getMain().getTempMax());
            forecast.setHumidity(item.getMain().getHumidity());
            forecast.setPressure(item.getMain().getPressure());
            forecast.setWeatherCondition(item.getWeather().get(0).getDescription());

            result.add(forecast);
        }
        return result;
    }

    public List<WeatherSimple> getCitiesWeatherSimpleList(Long population, Double areaFrom, Double areaTo){
        List<WeatherSimple> weatherList = new ArrayList<>();

        List<City> cityList = null;
        if(population!=null){
            cityList = cityService.findAllByPopulation(population);
        } else if(areaFrom!=null && areaTo!=null){
            cityList = cityService.findAllByAreaBetween(areaFrom, areaTo);
        } else {
            cityList = cityService.findAll();
        }

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

        List<Forecast> forecastList = null;
        if(includeForecast){
            ForecastRoot forecastRoot = weatherClient.getForecastByCityId(city.getCityId());
            forecastList = buildForecastList(forecastRoot);
        }
        WeatherExtended weatherExtended = new WeatherExtended(city, weatherRoot, forecastList);

        return weatherExtended;
    }

    public WeatherSimple getWeatherSimpleByCoord(Double lon, Double lat, Boolean includeForecast){
        City city = cityService.findByCoordLonAndCoordLat(lon, lat);
        WeatherRoot weatherRoot = weatherClient.getWeatherByCityId(city.getCityId());

        List<Forecast> forecastList = null;
        if(includeForecast){
            ForecastRoot forecastRoot = weatherClient.getForecastByCityId(city.getCityId());
            forecastList = buildForecastList(forecastRoot);
        }

        WeatherSimple weatherSimple = new WeatherSimple(city, weatherRoot, forecastList);

        return weatherSimple;
    }


}
