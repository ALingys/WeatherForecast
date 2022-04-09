package task.weatherforecast.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.weatherforecast.user.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    User findByFirstName(String firstName);

    User findByLastName(String lastName);

    Iterable<User> findByFavoriteCitiesName(String name);
}
