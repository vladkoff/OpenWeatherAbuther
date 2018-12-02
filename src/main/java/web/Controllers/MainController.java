package web.Controllers;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import web.Entities.City;
import web.Entities.Weather;
import web.Entities.utilEntities.FiveDayWeather;
import web.services.CityService;
import web.services.DataProvider;
import web.services.JsonParser;
import web.services.WeatherService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


@Controller
public class MainController {


    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DataProvider dataProvider;

    @Autowired
    private JsonParser jsonParser;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private CityService cityService;

    @GetMapping("/")
    public String getWeather(Model model,
                             @RequestParam(value = "APIIDStr", required = false, defaultValue = "698740") String APIID,
                             @RequestParam(value = "isOneDay", required = false, defaultValue = "false") boolean isOneDay) throws IOException{

        List<City> cities = cityService.getAllCities();

        long APIIDL = new Long(APIID.replace("\u00a0", ""));


        if(isOneDay){
            List<Weather> weatherList = weatherService.getWeathersCityOneDay(cityService.getCityByAPIID(APIIDL));

            model.addAttribute("weatherList", weatherList);
        }
        else {
            List<FiveDayWeather> weathersFiveDays = weatherService.getWeathersCityFiveDays(cityService.getCityByAPIID(APIIDL));

            model.addAttribute("weathersFiveDays", weathersFiveDays);
        }

        model.addAttribute("isOneDay", isOneDay);
        model.addAttribute("cities", cities);

        return "main";
    }

    @GetMapping("/addCity")
    public String addCity(@RequestParam(value = "newCityName", required = true) String newCityName){
        try {
            cityService.addUnknownCity(newCityName);
        }
        finally {
            return "redirect:/";
        }

    }

}
