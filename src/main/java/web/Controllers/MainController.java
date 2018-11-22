package web.Controllers;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import web.Entities.Weather;
import web.services.DataProvider;
import web.services.JsonParser;

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

    @GetMapping("/")
    public String getWeather(Model model) throws IOException{


        JSONObject jsonForCity = dataProvider.getJsonForCity(698740);

        List<Weather> weatherList = jsonParser.parse(jsonForCity);

        model.addAttribute("weatherList", weatherList);
        return "main";
    }

}
