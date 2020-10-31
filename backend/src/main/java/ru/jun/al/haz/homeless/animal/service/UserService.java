package ru.jun.al.haz.homeless.animal.service;

import ru.jun.al.haz.homeless.animal.models.User;
import ru.jun.al.haz.homeless.animal.service.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO register(UserDTO user);

    List<UserDTO> getAll();

    UserDTO findByLogin(String login);

    UserDTO findById(Long id);

    void delete(Long id);
}
