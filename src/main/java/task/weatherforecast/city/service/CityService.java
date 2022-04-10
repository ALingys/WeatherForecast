package task.weatherforecast.city.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.repository.CityRepository;
import task.weatherforecast.citydetail.service.CityDetailService;

import java.util.List;

@Service
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
            cityId = findCityIdByName(cityNew.getName());
            checkIfCityIdExists(cityId);
        }

        city.setName(cityNew.getName());
        city.setPopulation(cityNew.getPopulation());
        city.setArea(cityNew.getArea());
        city.setCityId(cityId);

        return cityRepository.save(city);
    }

    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City findByCityId(Long cityId) {
        return cityRepository.findByCityId(cityId).orElse(null);
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }
}
