package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Тип животного: содержит информацию о типах (подтипах) животных
 */
@Data
@Entity
@Table(name = "typeOfPets")
public class TypeOfPet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfTypePets")
    private long idOfTypePets;

    @Column(name = "nameOfTypePets")
    private String nameOfTypePets;

    @OneToMany(mappedBy = "typeOfPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<BreedOfPet> breedOfPet;

    @OneToMany(mappedBy = "typeOfPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ColorOfPet> colorOfPet;

    @OneToMany(mappedBy = "typeOfPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TypeOfWoolPet> typeOfWoolPets;

    @OneToMany(mappedBy = "typeOfPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets;

    public TypeOfPet() {
    }
}
