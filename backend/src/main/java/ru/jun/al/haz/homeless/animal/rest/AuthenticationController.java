package ru.jun.al.haz.homeless.animal.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jun.al.haz.homeless.animal.security.jwt.JwtTokenProvider;
import ru.jun.al.haz.homeless.animal.service.UserService;
import ru.jun.al.haz.homeless.animal.service.dto.request.AuthenticationRequestDTO;
import ru.jun.al.haz.homeless.animal.service.dto.response.AuthenticationResponseDTO;
import ru.jun.al.haz.homeless.animal.service.dto.UserDTO;


@RestController
@RequestMapping(value = "/api/auth/")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDTO requestDTO) {
        try {
            String userLogin = requestDTO.getUserLogin();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin, requestDTO.getPassword()));
            UserDTO userDTO = userService.findByLogin(userLogin);
            if (userDTO == null)
                throw new UsernameNotFoundException("User with login: " + userLogin + " wasn't found");

            String token = jwtTokenProvider.createToken(userLogin, userDTO.getRoles());

            AuthenticationResponseDTO response = new AuthenticationResponseDTO();
            response.setLogin(userLogin);
            response.setToken(token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid credentials.");
        }
    }
}
