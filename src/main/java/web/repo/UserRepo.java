package web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import web.Entities.User;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
