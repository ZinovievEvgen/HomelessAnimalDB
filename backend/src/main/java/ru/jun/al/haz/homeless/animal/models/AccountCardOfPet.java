package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

/**
 * Слой сущностей БД (Model)
 * класс-Карточка учета животного: содержит информацию о характеристиках животного и его подробное описание
 */

@Data
@Entity
@Table(name = "accountCardOfPet")
public class AccountCardOfPet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfAccountCardOfPet")
    private Long idOfAccountCardOfPet;

    @OneToOne(mappedBy = "accountCardOfPet")
    private Pet pet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actOfCatchForPetId")
    private ActOfCatch actOfCatchForPet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actOfTransferOfPetId")
    private ActOfTransfer actOfTransferOfPetId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vaccinationOfPets",
            joinColumns = @JoinColumn(name = "accountCard_id"),
            inverseJoinColumns = @JoinColumn(name = "vaccination_id"))
    private List<VaccinationOfPet> vaccinationOfPets = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "actOfVetInspectionOfPetId")
    private ActOfVetInspection actOfVetInspectionOfPetId;

    //номер
    @Column(name = "numberAccountCardOfPet")
    private String numberAccountCardOfPet;

    //возраст
    @Column(name = "ageOfPet")
    private String ageOfPet;

    //вес
    @Column(name = "weightOfPet")
    private Long weightOfPet;

    //окрас
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "colorOfPetId")
    @JsonBackReference
    private ColorOfPet colorOfPet;

    //уши
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeOfEarPetId")
    @JsonBackReference
    private TypeOfEarPet typeOfEarPet;

    //шерсть
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeOfWoolPetId")
    @JsonBackReference
    private TypeOfWoolPet typeOfWoolPet;

    //хвост
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "typeOfTailPetId")
    @JsonBackReference
    private TypeOfTailPet typeOfTailPet;

    //размер
    @Column(name = "sizeOfPet")
    private String sizeOfPet;

    //особые приметы
    @Column(name = "signOfPet")
    private String signOfPet;

    //вольер
    @Column(name = "enclosure")
    private Long enclosure;

    //дата стерилизации
    @Column(name = "dateOfSterilization")
    private Date dateOfSterilization;

    //фио врача
    @Column(name = "veterinarianOfPet")
    private String veterinarianOfPet;

    //фио опекун
    @Column(name = "patronizeOfPet")
    private String patronizeOfPet;

    //фио юр лицо
    @Column(name = "physicalPersonOfPet")
    private String physicalPersonOfPet;

    //фио физ лицо
    @Column(name = "legalPersonOfPet")
    private String legalPersonOfPet;

    public AccountCardOfPet() {
    }
}
