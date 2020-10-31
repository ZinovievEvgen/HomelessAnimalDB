package ru.jun.al.haz.homeless.animal.service.dto.request;

import lombok.Data;

@Data
public class GetPetClassRequestDTO {
    private String idOfPet;
    private String nameOfTypePet;
    private String sizeOfPet;
    private String nameOfColorPet;
    private String nameOfTypeWoolPet;
    private String nameOfTypeEarPet;
    private String nameOfTypeOfTailPet;
}
