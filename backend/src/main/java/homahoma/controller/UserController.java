package homahoma.controller;

import homahoma.model.User;
import homahoma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    private Logger logger = Logger.getLogger(UserController.class.getName());

    @PostMapping("/create")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id) throws Exception {
        return userService.getUserById(id);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Long id) {
        try {
            userService.deleteUserById(id);
            logger.info("User (id = " + id + ") was deleted");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User newUser) throws Exception {
        userService.updateUser(newUser);
    }
}
