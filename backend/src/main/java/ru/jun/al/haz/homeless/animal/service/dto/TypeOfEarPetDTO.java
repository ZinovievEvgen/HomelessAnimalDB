package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TypeOfEarPetDTO implements Serializable {

    private long idOfTypeEarPet;
    private String nameOfTypeEarPet;
    private List<AccountCardOfPetDTO> accountCardOfPetDTOList;
}
