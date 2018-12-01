package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Entities.City;
import web.Entities.Weather;
import web.Entities.utilEntities.FiveDayWeather;
import web.repo.WeatherRepo;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private static final long millisInDay = 86400000;

    @Autowired
    private WeatherRepo weatherRepo;


    public List<FiveDayWeather> getWeathersCityFiveDays(City city) throws InvalidPropertiesFormatException {

        List<Weather> weathers = weatherRepo.findAllByCity(city);

        Map<Integer, List<Weather>> calcMap = new HashMap<>();


        for (Weather weather : weathers) {
            if (!calcMap.containsKey(weather.getDate().getDay())) {
                calcMap.put(weather.getDate().getDay(), new ArrayList<>());
            }
            calcMap.get(weather.getDate().getDay()).add(weather);
        }

        List<FiveDayWeather> fiveDayWeathers = new ArrayList<>();
        FiveDayWeather fiveDayWeatherTMP;
        for (int day : calcMap.keySet()) {
            fiveDayWeatherTMP = new FiveDayWeather();
            fiveDayWeatherTMP.setMaxTmp((calcMap.get(day)
                    .stream()
                    .max(Comparator.comparing(Weather::getTemperature))
                    .orElseThrow(NoSuchElementException::new))
                    .getTemperature());

            fiveDayWeatherTMP.setMinTmp((calcMap.get(day)
                    .stream()
                    .min(Comparator.comparing(Weather::getTemperature))
                    .orElseThrow(NoSuchElementException::new))
                    .getTemperature());

            fiveDayWeatherTMP.setHumidity((long) (calcMap.get(day)
                    .stream()
                    .mapToLong(Weather::getHumidity)
                    .average()
                    .orElseThrow(NoSuchElementException::new)));

            fiveDayWeatherTMP.setPressure((calcMap.get(day)
                    .stream()
                    .mapToDouble(Weather::getPressure)
                    .average()
                    .orElseThrow(NoSuchElementException::new)));



            Set<String> uniqueStates = calcMap.get(day)
                    .stream()
                    .map(Weather::getState)
                    .collect(Collectors.toSet());


            fiveDayWeatherTMP.setState(uniqueStates
                    .stream()
                    .max(Comparator.comparing(s -> Collections.frequency(calcMap.get(day), s)))
                    .orElseThrow(NoSuchFieldError::new));

            fiveDayWeatherTMP.setDay(day != 0 ? day : 7);

            fiveDayWeathers.add(fiveDayWeatherTMP);
        }

        fiveDayWeathers.sort(Comparator.comparing(weather -> weather.getDay() % new Date().getDay()));

        return fiveDayWeathers;
    }

    public List<Weather> getWeathersCityOneDay(City city) {
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + millisInDay);


        return weatherRepo.findAllByCityAndDateBetween(city, startDate, endDate);
    }

    public void saveWeather(Weather weather) {
        weatherRepo.save(weather);
    }

    public void deleteAllWeathers() {
        weatherRepo.deleteAll();
    }
}
