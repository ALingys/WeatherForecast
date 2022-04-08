package task.weatherforecast.citydetail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.weatherforecast.citydetail.entity.CityDetail;

@Repository
public interface CityDetailRepository extends JpaRepository<CityDetail, Long> {
    CityDetail findByNameIgnoreCase(String name);
}
