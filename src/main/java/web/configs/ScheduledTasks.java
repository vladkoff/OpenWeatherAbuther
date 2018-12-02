package web.configs;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import web.Entities.City;
import web.Entities.Weather;
import web.services.CityService;
import web.services.DataProvider;
import web.services.JsonParser;
import web.services.WeatherService;

@Component
public class ScheduledTasks {

    private static final long millisecondsInDay = 86400000;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    @Autowired
    private CityService cityService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private DataProvider dataProvider;

    @Autowired
    private JsonParser jsonParser;

    @Scheduled(fixedRate = millisecondsInDay)
    public void reportCurrentTime() throws IOException {
        weatherService.deleteAllWeathers();
        for (City city: cityService.getAllCities()){
            List<Weather> weathers = jsonParser.parse(dataProvider.getWeatherJsonForCity(city.getApiId()));
            for (Weather weather: weathers){
                weather.setCity(city);
                weatherService.saveWeather(weather);
            }
        }
    }



}