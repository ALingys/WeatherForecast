package task.weatherforecast.weather.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import task.weatherforecast.weather.client.model.WeatherRoot;

@Component
@AllArgsConstructor
public class WeatherClientImpl implements WeatherClient{
    private RestTemplate restTemplate;

    private static final String URL_ROOT = "http://api.openweathermap.org/data/2.5/weather";
    private static final String API_KEY = "e74a022d94a4890c953469e263a8cce0";

    public WeatherRoot getWeatherByCityId(Long cityId){
        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?id=593116&units=metric&appid=e74a022d94a4890c953469e263a8cce0", WeatherRoot.class);
    }
}
