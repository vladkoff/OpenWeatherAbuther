package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Entities.Weather;
import web.repo.WeatherRepo;

import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepo weatherRepo;



    public List<Weather> getWeathersCityFiveDays(){

        return null;
    }

    public List<Weather> getWeathersCityOneDay(){

        return null;
    }

    public void saveWeather(Weather weather){
        weatherRepo.save(weather);
    }

    public void deleteAllWeathers(){
        weatherRepo.deleteAll();
    }
}
