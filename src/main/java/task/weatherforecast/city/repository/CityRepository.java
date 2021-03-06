package task.weatherforecast.city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.weatherforecast.city.entity.City;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByCityId(Long cityId);

    City findByCoordLonAndCoordLat(Double coordLon, Double coordLat);

    List<City> findAllByAreaBetween(Double areaFrom, Double areaTo);

    List<City> findAllByPopulation(Long population);
}
