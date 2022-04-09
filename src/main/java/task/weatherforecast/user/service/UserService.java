package task.weatherforecast.user.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import task.weatherforecast.user.entity.User;
import task.weatherforecast.user.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "user with username %s not found.";
    private final static String USER_ID_NOT_FOUND_MSG = "user with id %d not found.";

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private void checkIfUserExists(String username){
        boolean userExists = userRepository
                .findByUsername(username)
                .isPresent();
        if(userExists){
            throw new IllegalStateException("username already taken.");
        }
    }

    public User saveUser(User user){
        checkIfUserExists(user.getUsername());

        String passwordEncoded = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);

        return userRepository.save(user);
    }

    public User updateUser(Long id, User userNew){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(String.format(USER_ID_NOT_FOUND_MSG, id)));

        if(!user.getUsername().equals(userNew.getUsername())){
            checkIfUserExists(userNew.getUsername());
        }
        
        String passwordEncoded = bCryptPasswordEncoder.encode(userNew.getPassword());

        user.setUsername(userNew.getUsername());
        user.setFirstName(userNew.getFirstName());
        user.setLastName(userNew.getLastName());
        user.setHomeLocation(userNew.getHomeLocation());
        user.setLocked(userNew.getLocked());
        user.setEnabled(userNew.getEnabled());
        user.setPassword(passwordEncoded);

        return userRepository.save(userNew);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
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
