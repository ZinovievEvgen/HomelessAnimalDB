package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Тип пола животного: содержит информацию о типах (подтипах) пола животных
 */
@Data
@Entity
@Table(name = "typeOfSexOnPet")
public class TypeOfSex {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private long idOfTypeSexOnPet;

    @Column(name = "nameOfTypeSexOnPet")
    private String nameOfTypeSexOnPet;

    @OneToMany(mappedBy = "typeOfSex", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets;

    public TypeOfSex() {
    }
}
