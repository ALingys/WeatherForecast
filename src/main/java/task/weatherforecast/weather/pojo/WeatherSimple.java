package task.weatherforecast.weather.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.weather.client.model.forecast.ForecastRoot;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;

import java.util.List;

@Data
@NoArgsConstructor
public class WeatherSimple {
    private City city;
    private Double tempMin;
    private Double tempMax;
    private String weatherCondition;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Forecast> forecastList;

    public WeatherSimple(City city, WeatherRoot weatherRoot){
        setCity(city);
        setTempMin(weatherRoot.getMain().getTempMin());
        setTempMax(weatherRoot.getMain().getTempMax());
        setWeatherCondition(weatherRoot.getWeather().get(0).getDescription());
    }

    public WeatherSimple(City city, WeatherRoot weatherRoot, List<Forecast> forecastList){
        this(city, weatherRoot);
        setForecastList(forecastList);
    }
}
