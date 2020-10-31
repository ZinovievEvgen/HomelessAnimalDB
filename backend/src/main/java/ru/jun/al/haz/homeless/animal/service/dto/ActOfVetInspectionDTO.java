package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActOfVetInspectionDTO implements Serializable {

    private Long idOfActOfVetInspection;
    private Date dateOfActOfVetInspection;
    private String anamnesisOfActOfVetInspection;
    private AccountCardOfPetDTO accountCardOfPetDTO;

}
