package ru.jun.al.haz.homeless.animal.security.jwt;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.jun.al.haz.homeless.animal.service.dto.RoleDTO;
import ru.jun.al.haz.homeless.animal.service.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.stream.Collectors;

public final class JwtUserFactory {

    public JwtUserFactory () {}

    public static JwtUser create(UserDTO userDTO) {
        return new JwtUser(userDTO.getId(), userDTO.getLogin(), userDTO.getFio(), userDTO.getPassword(),
                userDTO.getEmail(), getGrantedAuthorities(new ArrayList<>(userDTO.getRoles())));
    }

    private static List<GrantedAuthority> getGrantedAuthorities(List<RoleDTO> userRoles) {
        return userRoles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
}
