package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PetDTO implements Serializable {

    private Long idOfPet;
    private String nameOfPet;
    private BreedOfPetDTO breedOfPetDTO;
    private ShelterOfPetDTO shelterOfPetDTO;
    private AccountCardOfPetDTO accountCardOfPetDTO;
    private TypeOfPetDTO typeOfPetDTO;
    private String pathOfPhotoOfPet;
    private TypeOfSexDTO typeOfSexDTO;
    private String controlPointOfPet;
    private String socialStatusOfPet;
}
