package task.weatherforecast.city.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.service.CityService;

import java.util.List;

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
    public City updateCity(@PathVariable("id") Long id, @RequestBody City cityNew){
        return cityService.updateCity(id, cityNew);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable("id") Long id){
        cityService.deleteById(id);
    }

    @GetMapping("/{id}")
    public City findById(@PathVariable("id") Long id){
        return cityService.findById(id);
    }

    @GetMapping("/")
    public List<City> findAll(){
        return cityService.findAll();
    }

}
