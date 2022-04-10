package task.weatherforecast.weather.client;

import task.weatherforecast.weather.client.model.forecast.ForecastRoot;
import task.weatherforecast.weather.client.model.weather.WeatherRoot;

public interface WeatherClient {
    WeatherRoot getWeatherByCityId(Long cityId);

    ForecastRoot getForecastByCityId(Long cityId);
}
