package task.weatherforecast.weather.pojo;

import lombok.Data;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;

import java.util.List;

@Data
public class WeatherExtended extends WeatherSimple{
    private Integer pressure;
    private Integer humidity;

    public WeatherExtended(City city, WeatherRoot weatherRoot, List<Forecast> forecastList){
        super(city, weatherRoot, forecastList);
        setPressure(weatherRoot.getMain().getPressure());
        setHumidity(weatherRoot.getMain().getHumidity());
    }
}
