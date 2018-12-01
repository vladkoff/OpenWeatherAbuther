package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.Entities.City;

import java.util.List;

public interface CityRepo extends JpaRepository<City, Long> {

    City getByApiId(Long apiId);

}
