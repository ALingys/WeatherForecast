package task.weatherforecast.weather.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wind {
    @JsonProperty("deg")
    private Integer deg;
    @JsonProperty("speed")
    private Double speed;
}
