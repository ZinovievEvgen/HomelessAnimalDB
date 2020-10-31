package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PrefectDTO implements Serializable {

    private Long idOfPrefect;
    private String nameOfPrefect;
    private List<ExploitingOrganizationDTO> exploitingOrganizationDTOList;
}
