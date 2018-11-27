package web.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import web.Entities.Weather;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class JsonParser {


    public List<Weather> parse(JSONObject APIJsonResponse){
        List<Weather> weathers = new ArrayList<>();
        int amountOfWeather = APIJsonResponse.getInt("cnt");

        JSONArray listOfWeatherJSON = APIJsonResponse.getJSONArray("list");

        for (int i = 0; i < amountOfWeather; i++) {
            JSONObject weatherJSON = listOfWeatherJSON.getJSONObject(i);
            weathers.add(new Weather(
                    weatherJSON.getJSONObject("main").getDouble("temp"),
                    weatherJSON.getJSONObject("main").getDouble("pressure"),
                    weatherJSON.getJSONObject("main").getLong("humidity"),
                    weatherJSON.getJSONArray("weather").getJSONObject(0).getString("main"),
                    new Date(weatherJSON.getLong("dt")* 1000),
                    null
            ));
        }
        return weathers;
    }
}
