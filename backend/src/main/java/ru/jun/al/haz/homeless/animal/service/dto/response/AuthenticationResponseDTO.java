package ru.jun.al.haz.homeless.animal.service.dto.response;

import lombok.Data;

@Data
public class AuthenticationResponseDTO {
    private String login;
    private String token;
}
