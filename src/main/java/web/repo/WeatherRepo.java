package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.Entities.Weather;

public interface WeatherRepo extends JpaRepository<Weather, Long> {
}
