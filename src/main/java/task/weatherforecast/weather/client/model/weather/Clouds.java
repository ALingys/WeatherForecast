package task.weatherforecast.weather.client.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Clouds {
    @JsonProperty("all")
    private Integer all;
}
