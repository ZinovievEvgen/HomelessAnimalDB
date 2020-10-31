package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ActOfCatchDTO implements Serializable {

    private Long idOfActOfCatch;
    private String districtOfCatch;
    private String addressOnPlaceOfCatchPet;
    private String numberActOfCatchPet;
    private AccountCardOfPetDTO accountCardOfPetDTO;
}
