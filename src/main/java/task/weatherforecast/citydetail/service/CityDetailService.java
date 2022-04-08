package task.weatherforecast.citydetail.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import task.weatherforecast.citydetail.entity.CityDetail;
import task.weatherforecast.citydetail.repository.CityDetailRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class CityDetailService {
    private CityDetailRepository cityDetailRepository;

    public Iterable<CityDetail> list(){
        return cityDetailRepository.findAll();
    }

    public Iterable<CityDetail> saveAll(List<CityDetail> cityDetails){
        return cityDetailRepository.saveAll(cityDetails);
    }

    public CityDetail findByName(String name){
        return cityDetailRepository.findByNameIgnoreCase(name);
    }
}
