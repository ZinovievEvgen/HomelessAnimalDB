package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class AccountCardOfPetDTO implements Serializable {
    private Long idOfAccountCardOfPet;
    private PetDTO petDTO;
    // как тут быть? тут должно быть просто id акта
    private ActOfCatchDTO actOfCatchDTO;
    private ActOfTransferDTO actOfTransferDTO;
    private ActOfLeaveDTO actOfLeaveDTO;
    private List<TreatmentFromParasiteDTO> treatmentFromParasiteDTOs;
    private List<VaccinationOfPetDTO> vaccinationOfPetDTOs;
    private ActOfVetInspectionDTO actOfVetInspectionDTO;
    private String numberAccountCardOfPet;
    private String ageOfPet;
    private Long weightOfPet;
    private ColorOfPetDTO colorOfPetDTO;
    private TypeOfEarPetDTO typeOfEarPetDTO;
    private TypeOfWoolPetDTO typeOfWoolPetDTO;
    private ReasonToLeaveDTO reasonToLeaveDTO;
    private Date dateOfLeave;
    private TypeOfTailPetDTO typeOfTailPetDTO;
    private String sizeOfPet;
    private String signOfPet;
    private Long enclosure;
    private Date dateOfSterilization;
    private String veterinarianOfPet;
    private String patronizeOfPet;
    private String physicalPersonOfPet;
    private String legalPersonOfPet;
}
