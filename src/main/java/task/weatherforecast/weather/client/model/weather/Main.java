package task.weatherforecast.weather.client.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Main {
    @JsonProperty("feels_like")
    private Double feelsLike;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("pressure")
    private Integer pressure;
    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("temp_max")
    private Double tempMax;
    @JsonProperty("temp_min")
    private Double tempMin;
}
