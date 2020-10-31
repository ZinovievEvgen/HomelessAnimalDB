package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

@Data
public class AuthenticationResponseDTO {
    private String login;
    private String token;
}
