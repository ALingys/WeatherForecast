package task.weatherforecast.user.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import task.weatherforecast.user.entity.User;
import task.weatherforecast.user.repository.UserRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "user with username %s not found.";

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User user){
        log.info("UserService.saveUser");

        boolean userExists = userRepository
                .findByUsername(user.getUsername())
                .isPresent();
        if(userExists){
            throw new IllegalStateException("username already taken.");
        }

        String passwordEncoded = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, username)));
    }

    public User findUserByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }

    public User findUserByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
