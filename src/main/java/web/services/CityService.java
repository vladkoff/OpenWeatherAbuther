package web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.Entities.City;
import web.repo.CityRepo;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepo cityRepo;

    public void addCity(City city){
        cityRepo.save(city);
    }

    public List<City> getAllCities(){
        return cityRepo.findAll();
    }

}
