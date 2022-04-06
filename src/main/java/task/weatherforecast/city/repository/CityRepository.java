package task.weatherforecast.city.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.weatherforecast.city.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByCityId(Long cityId);

    void deleteByCityId(Long cityId);
}
