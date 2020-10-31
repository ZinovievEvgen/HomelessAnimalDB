package ru.jun.al.haz.homeless.animal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.jun.al.haz.homeless.animal.service.UserService;
import ru.jun.al.haz.homeless.animal.service.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("create")
    public UserDTO createUser(@RequestBody UserDTO userDTO) throws Exception {
        if (userDTO.getId() != null)
            throw new Exception("A new user already has id");
        return userService.register(userDTO);
    }
}
