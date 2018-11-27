package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import web.Entities.City;
import web.services.CityService;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableScheduling
public class Application {

    @Autowired
    private CityService cityService;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }


    @PostConstruct
    public void initIt() {
        cityService.addCity(new City("Odessa", (long) 698740, null, null));
        cityService.addCity(new City("Kiev", (long) 703448, null, null));
        cityService.addCity(new City("Lviv", (long) 702550, null, null));
        cityService.addCity(new City("Ternopil", (long) 691650, null, null));
        cityService.addCity(new City("Chernivtsi", (long) 710719, null, null));
        cityService.addCity(new City("Lutsk", (long) 702569, null, null));
        cityService.addCity(new City("Kirovohrad", (long) 705812, null, null));
        cityService.addCity(new City("Sumy", (long) 692194, null, null));
        cityService.addCity(new City("Chernihiv", (long) 710735, null, null));
        cityService.addCity(new City("Cherkasy", (long) 710791, null, null));
    }

}
