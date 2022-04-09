package task.weatherforecast.weather.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sys {
    @JsonProperty("country")
    private String country;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("sunrise")
    private Integer sunrise;
    @JsonProperty("sunset")
    private Integer sunset;
    @JsonProperty("type")
    private Integer type;
}
