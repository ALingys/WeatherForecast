package task.weatherforecast.city.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long cityId;
    private String name;
    private Double area;
    private Long population;
    @JsonProperty("coord_lon")
    private Double coordLon;
    @JsonProperty("coord_lat")
    private Double coordLat;
}
