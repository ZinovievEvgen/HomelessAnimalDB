package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TypeOfWoolPetDTO implements Serializable {

    private long idOfTypeWoolPet;
    private String nameOfTypeWoolPet;
    private List<AccountCardOfPetDTO> accountCardOfPetDTOList;
    private TypeOfPetDTO typeOfPetDTO;
}
