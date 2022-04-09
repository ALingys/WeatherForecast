package task.weatherforecast.weather.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherSimple {
    private Double tempMin;
    private Double tempMax;
    private String weatherCondition;
}
