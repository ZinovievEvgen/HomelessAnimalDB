package ru.jun.al.haz.homeless.animal.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.jun.al.haz.homeless.animal.security.jwt.JwtUser;
import ru.jun.al.haz.homeless.animal.security.jwt.JwtUserFactory;
import ru.jun.al.haz.homeless.animal.service.UserService;
import ru.jun.al.haz.homeless.animal.service.dto.UserDTO;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDTO user = userService.findByLogin(login);
        if(user == null) {
            throw new UsernameNotFoundException("User with login: " + login + " wasn't found.");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("User with login: {} sucessfully get jwt token", jwtUser);
        return jwtUser;
    }
}
