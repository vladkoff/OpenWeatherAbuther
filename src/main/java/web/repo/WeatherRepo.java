package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.Entities.City;
import web.Entities.Weather;

import java.util.Date;
import java.util.List;

public interface WeatherRepo extends JpaRepository<Weather, Long> {


    List<Weather> findAllByCityAndDateBetween(City city, Date dateStart, Date dateEnd);

    List<Weather> findAllByCity(City city);
}
