package task.weatherforecast.weather.client;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import task.weatherforecast.weather.client.model.forecast.ForecastRoot;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;

@Component
@Slf4j
@AllArgsConstructor
public class WeatherClientImpl implements WeatherClient{
    private RestTemplate restTemplate;

    private static final String URL_FORMAT = "http://api.openweathermap.org/data/2.5/%s?id=%s&units=metric&appid=%s";
    private static final String API_KEY = "e74a022d94a4890c953469e263a8cce0";

    public WeatherRoot getWeatherByCityId(Long cityId){
        String url = String.format(URL_FORMAT, "weather", cityId, API_KEY);
        log.info("getWeatherByCityId call url: " + url);
        return restTemplate.getForObject(url, WeatherRoot.class);
    }

    public ForecastRoot getForecastByCityId(Long cityId){
        String url = String.format(URL_FORMAT, "forecast", cityId, API_KEY);
        log.info("getForecastByCityId call url: " + url);
        return restTemplate.getForObject(url, ForecastRoot.class);
    }

}
