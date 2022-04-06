package task.weatherforecast.city.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.repository.CityRepository;

@Service
@Slf4j
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City saveCity(City city) {
        log.info("CityService.saveCity");
        return cityRepository.save(city);
    }

    public City findCityById(Long cityId) {
        log.info("CityService.findCityById");
        return cityRepository.findByCityId(cityId);
    }

    public void deleteByCityId(Long cityId) {
        log.info("CityService.deleteByCityId");
        cityRepository.deleteByCityId(cityId);
    }
}
