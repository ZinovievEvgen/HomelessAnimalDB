package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

@Data
public class AuthenticationRequestDTO {
    private String userLogin;
    private String password;
}
