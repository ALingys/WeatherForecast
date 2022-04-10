package task.weatherforecast.weather.client;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;

@Component
@Slf4j
@AllArgsConstructor
public class WeatherClientImpl implements WeatherClient{
    private RestTemplate restTemplate;

    private static final String URL_ROOT = "http://api.openweathermap.org/data/2.5";
    private static final String API_KEY = "e74a022d94a4890c953469e263a8cce0";

    public WeatherRoot getWeatherByCityId(Long cityId){
        String url = URL_ROOT + String.format("/weather?id=%s&units=metric&appid=%s", cityId, API_KEY);
        log.info("getWeatherByCityId call url:" + url);

        return restTemplate.getForObject(url, WeatherRoot.class);
    }

}
