package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TypeOfPetDTO implements Serializable {

    private long idOfTypePets;
    private String nameOfTypePets;
    private List<BreedOfPetDTO> breedOfPetDTOs;
    private List<ColorOfPetDTO> colorOfPet;
    private List<TypeOfWoolPetDTO> typeOfWoolPets;
    private List<PetDTO> pets;
}
