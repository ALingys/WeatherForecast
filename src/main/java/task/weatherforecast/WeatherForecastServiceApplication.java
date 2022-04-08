package task.weatherforecast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import task.weatherforecast.citydetail.entity.CityDetail;
import task.weatherforecast.citydetail.service.CityDetailService;

import java.io.InputStream;
import java.util.List;
@Slf4j
@SpringBootApplication
public class WeatherForecastServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CityDetailService cityDetailService) {
		return args -> {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CityDetail>> typeReference = new TypeReference<List<CityDetail>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data/city.list.json");
			List<CityDetail> cityDetails = mapper.readValue(inputStream, typeReference);
			cityDetailService.saveAll(cityDetails);
			log.info("City details Saved!");
		};
	}
}
