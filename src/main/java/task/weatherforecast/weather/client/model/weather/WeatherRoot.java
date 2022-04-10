package task.weatherforecast.weather.client.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherRoot {
    @JsonProperty("base")
    private String base;
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("cod")
    private Integer cod;
    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("timezone")
    private Integer timezone;
    @JsonProperty("visibility")
    private Integer visibility;
    @JsonProperty("weather")
    private List<Weather> weather = new ArrayList<Weather>();
    @JsonProperty("wind")
    private Wind wind;
}
