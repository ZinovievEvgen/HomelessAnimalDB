package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TypeOfSexDTO implements Serializable {

    private long idOfTypeSexOnPet;
    private String nameOfTypeSexOnPet;
    private List<PetDTO> petDTOList;
}
