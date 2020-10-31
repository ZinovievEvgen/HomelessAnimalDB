package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BreedOfPetDTO implements Serializable {

    private long idOfBreedOfPet;
    private String nameOfBreedOfPet;
    private List<PetDTO> pets;
    private TypeOfPetDTO typeOfPet;
}
