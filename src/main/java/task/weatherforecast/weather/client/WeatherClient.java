package task.weatherforecast.weather.client;

import task.weatherforecast.weather.client.model.WeatherRoot;

public interface WeatherClient {
    WeatherRoot getWeatherByCityId(Long cityId);
}
