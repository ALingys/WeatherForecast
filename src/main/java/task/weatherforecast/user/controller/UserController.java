package task.weatherforecast.user.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import task.weatherforecast.user.entity.User;
import task.weatherforecast.user.service.UserService;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id){
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/", params = "firstName", method = RequestMethod.GET)
    public User findUserByFirstName(@RequestParam(name = "firstName") String firstName){
        return userService.findUserByFirstName(firstName);
    }

    @RequestMapping(value = "/", params = "lastName", method = RequestMethod.GET)
    public User findUserByLastName(@RequestParam(name = "lastName") String lastName){
        return userService.findUserByLastName(lastName);
    }

    @RequestMapping(value = "/", params = "cityName", method = RequestMethod.GET)
    public Iterable<User> findByFavoriteCitiesName(@RequestParam(name = "cityName") String name){
        return userService.findByFavoriteCitiesName(name);
    }

    @GetMapping("/")
    public Iterable<User> getAllUsers(){
        return userService.findAll();
    }
}
