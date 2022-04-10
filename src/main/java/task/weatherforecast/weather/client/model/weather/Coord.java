package task.weatherforecast.weather.client.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coord {
    @JsonProperty("lat")
    private Double lat;
    @JsonProperty("lon")
    private Double lon;
}
