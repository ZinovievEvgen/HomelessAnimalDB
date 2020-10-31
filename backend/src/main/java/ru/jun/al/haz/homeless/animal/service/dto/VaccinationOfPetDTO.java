package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class VaccinationOfPetDTO implements Serializable {

    private Long idOfVaccinationOfPet;
    private String numberVaccinationOfPet;
    private Date dateOfVaccinationOfPet;
    private MedicamentDTO medicamentDTO;
    private List<AccountCardOfPetDTO> accountCardOfPetDTOList;
}
