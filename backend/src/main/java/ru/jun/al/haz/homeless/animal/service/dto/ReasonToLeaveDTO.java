package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ReasonToLeaveDTO implements Serializable {

    private long idOfReasonToLeave;
    private String nameOfReasonToLeave;
    private List<AccountCardOfPetDTO> accountCardOfPetDTOList;
    private List<ActOfLeaveDTO> actOfLeaveDTOs;
}
