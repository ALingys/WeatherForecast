package task.weatherforecast.weather.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import task.weatherforecast.city.entity.City;

@Data
@NoArgsConstructor
public class WeatherSimple {
    private City city;
    private Double tempMin;
    private Double tempMax;
    private String weatherCondition;
}
