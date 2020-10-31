package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TypeOfTailPetDTO implements Serializable {

    private long idOfTypeOfTailPet;
    private String nameOfTypeOfTailPet;
    private List<AccountCardOfPetDTO> accountCardOfPetDTOList;
}
