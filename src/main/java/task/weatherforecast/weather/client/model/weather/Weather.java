package task.weatherforecast.weather.client.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    @JsonProperty("description")
    private String description;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("main")
    private String main;
}
