package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TreatmentFromParasiteDTO implements Serializable {

    private Long idOfTreatmentFromParasite;
    private String numberTreatmentFromParasite;
    private Date dateOfTreatmentFromParasite;
    private MedicamentDTO medicamentDTO;
    private Double rangeOfTreatmentFromParasite;
    private AccountCardOfPetDTO accountCardOfPetDTO;
}
