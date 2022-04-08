package task.weatherforecast.citydetail.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CityDetail {
    @Id
    private Long id;
    private String name;
    private String state;
    private String country;

    @Embedded
    private Coord coord;
}
