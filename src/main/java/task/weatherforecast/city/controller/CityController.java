package task.weatherforecast.city.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.service.CityService;

@RestController
@RequestMapping("/api/cities")
@AllArgsConstructor
public class CityController {
    private final CityService cityService;

    @PostMapping("/")
    public City saveCity(@RequestBody City city){
        return cityService.saveCity(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable("id") Long id, @RequestBody City cityUpdate){
        return cityService.updateCity(id, cityUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable("id") Long id){
        cityService.deleteById(id);
    }

    @GetMapping("/{id}")
    public City findById(@PathVariable("id") Long cityId){
        return cityService.findById(cityId);
    }

}
