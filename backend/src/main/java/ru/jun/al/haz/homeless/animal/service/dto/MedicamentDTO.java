package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MedicamentDTO implements Serializable {

    private Long idOfMedicament;
    private String numberSeriesMedicament;
    private Long countMedicament;
    private List<VaccinationOfPetDTO> vaccinationOfPetDTOList;
    private List<TreatmentFromParasiteDTO> treatmentFromParasiteDTOList;
}
