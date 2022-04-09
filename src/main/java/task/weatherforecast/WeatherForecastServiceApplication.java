package task.weatherforecast;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import task.weatherforecast.city.entity.City;
import task.weatherforecast.city.service.CityService;
import task.weatherforecast.citydetail.entity.CityDetail;
import task.weatherforecast.citydetail.service.CityDetailService;
import task.weatherforecast.user.entity.User;
import task.weatherforecast.user.service.UserService;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
@Slf4j
@SpringBootApplication
public class WeatherForecastServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner loadData(CityDetailService cityDetailService, UserService userService, CityService cityService) {
		return args -> {
			//Load data from city.list.json file to DB table
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<CityDetail>> typeReference = new TypeReference<List<CityDetail>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/data/city.list.json");
			List<CityDetail> cityDetails = mapper.readValue(inputStream, typeReference);
			cityDetailService.saveAll(cityDetails);
			log.info("City details created.");

			//Load some cities for test
			City cityVilnius = new City();
			cityVilnius.setName("Vilnius");
			cityVilnius.setPopulation(544386L);
			cityVilnius.setArea(new BigDecimal(401));
			cityService.saveCity(cityVilnius);
			log.info("City Vilnius created.");

			City cityKaunas = new City();
			cityKaunas.setName("Kaunas");
			cityKaunas.setPopulation(295269L);
			cityKaunas.setArea(new BigDecimal(157));
			cityService.saveCity(cityKaunas);
			log.info("City Kaunas created.");

			City cityAlytus = new City();
			cityAlytus.setName("Alytus");
			cityAlytus.setPopulation(49551L);
			cityAlytus.setArea(new BigDecimal(48));
			cityService.saveCity(cityAlytus);
			log.info("City Alytus created.");

			//Load some users for test
			{
				User user = new User();
				user.setUsername("testUser1");
				user.setPassword("testUser1");
				user.setFirstName("FirstName1");
				user.setLastName("LastName1");
				user.setLocked(false);
				user.setEnabled(true);

				user.setFavoriteCities(Arrays.asList(new City[]{cityVilnius, cityKaunas}));
				userService.saveUser(user);
				log.info("User testUser1 created.");
			}
			
			{
				User user = new User();
				user.setUsername("testUser2");
				user.setPassword("testUser2");
				user.setFirstName("FirstName2");
				user.setLastName("LastName2");
				user.setLocked(false);
				user.setEnabled(true);

				user.setFavoriteCities(Arrays.asList(new City[]{cityVilnius, cityAlytus}));
				userService.saveUser(user);
				log.info("User testUser2 created.");
			}
		};
	}
}
