package ru.jun.al.haz.homeless.animal.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReasonOfEuthanizeDTO implements Serializable {

    private long idOfReasonEuthanize;
    private String nameOfReasonEuthanize;
}
