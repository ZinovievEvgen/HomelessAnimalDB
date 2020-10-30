package ru.jun.al.haz.homeless.animal.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Слой сущностей БД (Model)
 * класс-Тип смерти животных: содержит информацию о типах (подтипах) смерти животных
 */
@Data
@Entity
@Table(name = "reasonOnDeathPet")
public class ReasonOnDeathPet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfReasonOnDeathPet")
    private long idOfReasonOnDeathPet;

    @Column(name = "nameOfReasonOnDeathPet")
    private String nameOfReasonOnDeathPet;

    public ReasonOnDeathPet() {
    }
}
