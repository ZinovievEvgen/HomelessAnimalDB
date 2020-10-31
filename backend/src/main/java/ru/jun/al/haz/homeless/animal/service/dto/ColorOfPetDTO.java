package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ColorOfPetDTO implements Serializable {

    private long idOfColorPet;
    private String nameOfColorPet;
    private List<AccountCardOfPetDTO> accountCardOfPetDTOList;
    private TypeOfPetDTO typeOfPetDTO;
}
