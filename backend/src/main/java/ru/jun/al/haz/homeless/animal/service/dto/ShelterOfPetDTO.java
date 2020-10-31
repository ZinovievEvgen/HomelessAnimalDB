package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ShelterOfPetDTO implements Serializable {

    private Long idOfShelterOfPet;
    private String nameOfShelterOfPet;
    private String addressOfShelterOfPet;
    private String chiefOfShelterOfPet;
    private String emailOfShelterOfPet;
    private String phoneOfShelterOfPet;
    private String urlOfShelterOfPet;
    private List<PetDTO> petDTOs;
    private ExploitingOrganizationDTO exploitingOrganizationDTO;
}
