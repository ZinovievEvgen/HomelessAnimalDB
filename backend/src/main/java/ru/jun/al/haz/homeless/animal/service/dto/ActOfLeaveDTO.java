package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ActOfLeaveDTO implements Serializable {

    private Long idOfActOfLeave;
    private String numberActOfLeave;
    private Date dateOfActOfLeave;
    private ReasonToLeaveDTO reasonToLeaveDTO;
    private AccountCardOfPetDTO accountCardOfPetDTO;
}
