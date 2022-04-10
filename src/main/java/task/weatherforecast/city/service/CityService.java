package task.weatherforecast.city.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.repository.CityRepository;
import task.weatherforecast.citydetail.entity.CityDetail;
import task.weatherforecast.citydetail.service.CityDetailService;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityDetailService cityDetailService;

    private CityDetail findCityDetailsByCityName(String cityName){
        return cityDetailService.findByName(cityName);
    }

    private void fillCityWithDetails(City city, CityDetail cityDetail){
        if(cityDetail == null){
            throw new IllegalStateException("city details not found.");
        }
        city.setCityId(cityDetail.getId());
        city.setCoordLat(cityDetail.getCoord().getLat());
        city.setCoordLon(cityDetail.getCoord().getLon());
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
        CityDetail cityDetail = findCityDetailsByCityName(city.getName());
        checkIfCityIdExists(cityDetail.getId());
        fillCityWithDetails(city, cityDetail);

        return cityRepository.save(city);
    }

    public City updateCity(Long id, City cityNew){
        City city = findById(id);

        if(!city.getName().equals(cityNew.getName())){
            CityDetail cityDetail = findCityDetailsByCityName(city.getName());
            checkIfCityIdExists(cityDetail.getId());
            fillCityWithDetails(city, cityDetail);
        }

        city.setName(cityNew.getName());
        city.setPopulation(cityNew.getPopulation());
        city.setArea(cityNew.getArea());

        return cityRepository.save(city);
    }

    public City findById(Long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public City findByCityId(Long cityId) {
        return cityRepository.findByCityId(cityId).orElse(null);
    }

    public City findByCoordLonAndCoordLat(Double coordLon, Double coordLat){
        return cityRepository.findByCoordLonAndCoordLat(coordLon,coordLat);
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    public List<City> findAllByAreaBetween(Double areaFrom, Double areaTo) {
        return cityRepository.findAllByAreaBetween(areaFrom, areaTo);
    }
    public List<City> findAllByPopulation(Long population){
        return cityRepository.findAllByPopulation(population);
    }

}
