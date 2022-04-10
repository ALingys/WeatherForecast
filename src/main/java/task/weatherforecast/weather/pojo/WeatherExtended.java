package task.weatherforecast.weather.pojo;

import lombok.Data;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;

@Data
public class WeatherExtended extends WeatherSimple{
    private Integer pressure;
    private Integer humidity;

    public WeatherExtended(City city, WeatherRoot weatherRoot){
        super(city, weatherRoot);
        setPressure(weatherRoot.getMain().getPressure());
        setHumidity(weatherRoot.getMain().getHumidity());
    }
}
