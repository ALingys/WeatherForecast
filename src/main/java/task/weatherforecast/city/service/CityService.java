package task.weatherforecast.city.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.repository.CityRepository;
import task.weatherforecast.citydetail.entity.CityDetail;
import task.weatherforecast.citydetail.repository.CityDetailRepository;
import task.weatherforecast.citydetail.service.CityDetailService;

@Service
@Slf4j
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityDetailService cityDetailService;

    private Long findCityIdByName(String cityName){
        return cityDetailService.findByName(cityName).getId();
    }

    private void checkIfCityIdExists(Long cityId){
        boolean cityExists = cityRepository
                .findByCityId(cityId)
                .isPresent();
        if(cityExists){
            throw new IllegalStateException("city already exists.");
        }
    }

    public City saveCity(City city) {
        Long cityId = findCityIdByName(city.getName());
        checkIfCityIdExists(cityId);
        city.setCityId(cityId);

        return cityRepository.save(city);
    }

    public City updateCity(Long id, City cityNew){
        City city = findById(id);

        Long cityId = city.getCityId();
        if(!city.getName().equals(cityNew.getName())){
            cityId = findCityIdByName(city.getName());
            checkIfCityIdExists(cityId);
        }

        city.setName(cityNew.getName());
        city.setPopulation(cityNew.getPopulation());
        city.setArea(cityNew.getArea());
        city.setCityId(cityId);

        return cityRepository.save(city);
    }

    public City findById(Long cityId) {
        return cityRepository.findById(cityId).orElse(null);
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }
}
