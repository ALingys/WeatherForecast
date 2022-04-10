package task.weatherforecast.weather.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;

@Data
@NoArgsConstructor
public class WeatherSimple {
    private City city;
    private Double tempMin;
    private Double tempMax;
    private String weatherCondition;

    public WeatherSimple(City city, WeatherRoot weatherRoot){
        setCity(city);
        setTempMin(weatherRoot.getMain().getTempMin());
        setTempMax(weatherRoot.getMain().getTempMax());
        setWeatherCondition(weatherRoot.getWeather().get(0).getDescription());
    }
}
