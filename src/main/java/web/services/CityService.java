package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Entities.City;
import web.repo.CityRepo;

import java.io.IOException;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private DataProvider dataProvider;

    @Autowired
    private JsonParser jsonParser;

    public void addCity(City city){
        cityRepo.save(city);
    }

    public List<City> getAllCities(){
        return cityRepo.findAll();
    }

    public City getCityByAPIID(long APIID){
        return cityRepo.getByApiId(APIID);
    }

    public void addUnknownCity(String name) throws IOException {
        cityRepo.save(jsonParser.getCityObjectFromJson(dataProvider.getJsonForCity(name)));
    }

}
