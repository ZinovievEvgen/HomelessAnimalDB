package ru.jun.al.haz.homeless.animal.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.jun.al.haz.homeless.animal.models.Role;
import ru.jun.al.haz.homeless.animal.models.User;
import ru.jun.al.haz.homeless.animal.repository.RoleRepository;
import ru.jun.al.haz.homeless.animal.repository.UserRepository;
import ru.jun.al.haz.homeless.animal.service.RoleService;
import ru.jun.al.haz.homeless.animal.service.UserService;
import ru.jun.al.haz.homeless.animal.service.dto.RoleDTO;
import ru.jun.al.haz.homeless.animal.service.dto.UserDTO;
import ru.jun.al.haz.homeless.animal.service.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserMapper userMapper;

    //@Autowired
    //private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDTO register(UserDTO userDTO) {
        log.info("Request to register user: {}", userDTO);
        RoleDTO roleUser = roleService.findByName("USER");
        List<RoleDTO> userRoles = new ArrayList<>();
        userRoles.add(roleUser);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDTO.setRoles(userRoles);
        User user = new User();
        user = userRepository.save(user);
        log.info("User: {} was registered successfully", user);
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDTO> getAll() {
        log.info("Request to get all users");
        return userMapper.toDto(userRepository.findAll());
    }

    @Override
    public UserDTO findByLogin(String login) {
        log.info("Request to get user by login: {}", login);
        return userMapper.toDto(userRepository.findByLogin(login));
    }

    @Override
    public UserDTO findById(Long id) {
        log.info("Request to get user by id: {}", id);
        return userMapper.toDto(userRepository.findById(id).orElse(null));
    }

    @Override
    public void delete(Long id) {
        log.info("Request to delete user by id: {}", id);
        userRepository.deleteById(id);
    }
}
