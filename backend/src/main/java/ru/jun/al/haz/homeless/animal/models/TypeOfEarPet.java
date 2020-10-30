package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Тип ушных раковин животного: содержит информацию о типах (подтипах) ушных раковин животных
 */
@Data
@Entity
@Table(name = "typeOfEarPet")
public class TypeOfEarPet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfTypeEarPet")
    private long idOfTypeEarPet;

    @Column(name = "nameOfTypeEarPet")
    private String nameOfTypeEarPet;

    @OneToMany(mappedBy = "typeOfEarPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AccountCardOfPet> accountCardOfPet;

    public TypeOfEarPet() {
    }
}
