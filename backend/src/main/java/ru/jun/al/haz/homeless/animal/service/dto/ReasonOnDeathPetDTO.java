package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReasonOnDeathPetDTO implements Serializable {

    private long idOfReasonOnDeathPet;
    private String nameOfReasonOnDeathPet;
}
