package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.Entities.City;

public interface CityRepo extends JpaRepository<City, Long> {
}
