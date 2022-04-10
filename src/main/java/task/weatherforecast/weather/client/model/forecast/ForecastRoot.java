
package task.weatherforecast.weather.client.model.forecast;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "city",
    "cnt",
    "cod",
    "list",
    "message"
})
@Generated("jsonschema2pojo")
public class ForecastRoot {

    @JsonProperty("city")
    private City city;
    @JsonProperty("cnt")
    private Integer cnt;
    @JsonProperty("cod")
    private String cod;
    @JsonProperty("list")
    private java.util.List<task.weatherforecast.weather.client.model.forecast.List> list = null;
    @JsonProperty("message")
    private Integer message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

    @JsonProperty("cnt")
    public Integer getCnt() {
        return cnt;
    }

    @JsonProperty("cnt")
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    @JsonProperty("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    @JsonProperty("list")
    public java.util.List<task.weatherforecast.weather.client.model.forecast.List> getList() {
        return list;
    }

    @JsonProperty("list")
    public void setList(java.util.List<task.weatherforecast.weather.client.model.forecast.List> list) {
        this.list = list;
    }

    @JsonProperty("message")
    public Integer getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(Integer message) {
        this.message = message;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
