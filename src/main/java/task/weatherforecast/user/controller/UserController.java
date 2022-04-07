package task.weatherforecast.user.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import task.weatherforecast.user.entity.User;
import task.weatherforecast.user.service.UserService;

@RestController
@RequestMapping("/users")
@Slf4j
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("UserController.saveUser");
        return userService.saveUser(user);
    }
}
