package task.weatherforecast.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.weatherforecast.user.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findByFavoriteCitiesName(String name);

    List<User> findAllByFirstName(String firstName);

    List<User> findAllByLastName(String lastName);
}
