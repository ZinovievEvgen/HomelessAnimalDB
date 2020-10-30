package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

/**
 * Слой сущностей БД (Model)
 * класс-Животные: содержит информацию, ссылки на документы о животных и т.д.
 */
@Data
@Entity
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfPet")
    private Long idOfPet;

    //кличка
    @Column(name = "nameOfPet")
    private String nameOfPet;

    //порода
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "breedOfPetId")
    @JsonBackReference
    private BreedOfPet breedOfPet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shelterOfPetId")
    @JsonBackReference
    private ShelterOfPet shelterOfPetId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountCardOfPetId")
    private AccountCardOfPet accountCardOfPet;

    //тип животного
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeOfPetId")
    @JsonBackReference
    private TypeOfPet typeOfPet;

    @Column(name = "pathOfPhotoOfPet")
    private String pathOfPhotoOfPet;

    //пол
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeOfSexId")
    @JsonBackReference
    private TypeOfSex typeOfSex;

    //идентификационная метка
    @Column(name = "controlPointOfPet")
    private String controlPointOfPet;

    //софиализировано или нет
    @Column(name = "socialStatusOfPet")
    private String socialStatusOfPet;

    public Pet() {
    }
}
