package task.weatherforecast.weather.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Forecast {
    private Integer dt;
    private String dtTxt;
    private Double temp;
    private Double tempMin;
    private Double tempMax;
    private Integer humidity;
    private Integer pressure;
    private String weatherCondition;
}
