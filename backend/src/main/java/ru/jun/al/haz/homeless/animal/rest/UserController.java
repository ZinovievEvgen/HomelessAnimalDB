package ru.jun.al.haz.homeless.animal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
