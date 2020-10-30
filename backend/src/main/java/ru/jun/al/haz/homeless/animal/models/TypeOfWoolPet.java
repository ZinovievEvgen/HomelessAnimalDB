package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс - тип шерсти животного: содержит информацию о типах шерсти животных
 */
@Data
@Entity
@Table(name = "typeOfWoolPet")
public class TypeOfWoolPet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfTypeWoolPet")
    private long idOfTypeWoolPet;

    @Column(name = "nameOfTypeWoolPet")
    private String nameOfTypeWoolPet;

    @OneToMany(mappedBy = "typeOfWoolPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AccountCardOfPet> accountCardOfPet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeOfPetId")
    @JsonBackReference
    private TypeOfPet typeOfPet;

    public TypeOfWoolPet() {
    }
}
