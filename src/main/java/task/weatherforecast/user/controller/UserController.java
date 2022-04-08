package task.weatherforecast.user.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import task.weatherforecast.user.entity.User;
import task.weatherforecast.user.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("UserController.saveUser");
        return userService.saveUser(user);
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

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.findAll();
    }
}
