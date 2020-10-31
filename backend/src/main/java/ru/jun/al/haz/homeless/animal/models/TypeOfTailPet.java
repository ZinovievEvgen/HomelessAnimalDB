package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Тип хвостов животных: содержит информацию о типах (подтипах) хвостов животных
 */
@Data
@Entity
@Table(name = "typeOfTailPet")
public class TypeOfTailPet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private long idOfTypeOfTailPet;

    @Column(name = "nameOfTypeOfTailPet")
    private String nameOfTypeOfTailPet;

    @OneToMany(mappedBy = "typeOfTailPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AccountCardOfPet> accountCardOfPet;

    public TypeOfTailPet() {
    }
}
