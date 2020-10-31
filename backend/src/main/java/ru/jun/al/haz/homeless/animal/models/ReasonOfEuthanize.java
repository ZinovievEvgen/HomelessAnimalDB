package ru.jun.al.haz.homeless.animal.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Слой сущностей БД (Model)
 * класс-Тип смерти животных: содержит информацию о типах (подтипах) смерти животных
 */
@Data
@Entity
@Table(name = "reasonOfEuthanize")
public class ReasonOfEuthanize {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idOfReasonEuthanize")
    private long idOfReasonEuthanize;

    @Column(name = "nameOfReasonEuthanize")
    private String nameOfReasonEuthanize;
}
