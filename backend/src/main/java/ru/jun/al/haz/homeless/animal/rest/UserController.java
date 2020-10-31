package ru.jun.al.haz.homeless.animal.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.jun.al.haz.homeless.animal.service.UserService;
import ru.jun.al.haz.homeless.animal.service.dto.UserDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<UserDTO> getAllUsers() {
        log.info("REST request to get all users");
        return userService.getAll();
    }

    @PostMapping("create")
    public UserDTO createUser(@RequestBody UserDTO userDTO) throws Exception {
        log.info("REST request to create user: {}", userDTO);
        if (userDTO.getId() != null)
            throw new Exception("A new user already has id");
        return userService.register(userDTO);
    }
}
