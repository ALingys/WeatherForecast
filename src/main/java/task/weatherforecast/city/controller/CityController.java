package task.weatherforecast.city.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.service.CityService;

@RestController
@RequestMapping("/cities")
@Slf4j
@AllArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping("/")
    public City saveCity(@RequestBody City city){
        log.info("CityController.saveCity");
        return cityService.saveCity(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable("id") Long cityId, @RequestBody City cityDetails){
        log.info("CityController.updateCity");
        City city = findCityById(cityId);

        city.setName(cityDetails.getName());
        city.setArea(cityDetails.getArea());
        city.setPopulation(cityDetails.getPopulation());

        return cityService.saveCity(city);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable("id") Long cityId){
        log.info("CityController.deleteCity: " + cityId);
        cityService.deleteByCityId(cityId);
    }

    @GetMapping("/{id}")
    public City findCityById(@PathVariable("id") Long cityId){
        log.info("CityController.findCityById: " + cityId);
        return cityService.findCityById(cityId);
    }

}
