package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActOfTransferDTO implements Serializable {

    private Long idOfActOfTransferOfPet;
    private String numberActOfTransferOfPet;
    private Date dateOfActOfTransfer;
    private AccountCardOfPetDTO accountCardOfPetDTO;
}
