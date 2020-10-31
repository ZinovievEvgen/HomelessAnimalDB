package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "idOfActOfCatch")
    private ActOfCatch actOfCatchForPet;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idOfActOfTransferOfPet")
    private ActOfTransfer actOfTransferOfPetId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idOfActOfLeave")
    private ActOfLeave actOfLeave;

    @OneToMany(mappedBy = "accountCardOfPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TreatmentFromParasite> treatmentFromParasites;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vaccination-pet-list",
            joinColumns = @JoinColumn(name = "idOfAccountCardOfPet"),
            inverseJoinColumns = @JoinColumn(name = "idOfVaccinationOfPet"))
    private List<VaccinationOfPet> vaccinationOfPets = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idOfActOfVetInspection")
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
    @JoinColumn(name = "idOfColorPets")
    @JsonBackReference
    private ColorOfPet colorOfPet;

    //уши
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfTypeEarPet")
    @JsonBackReference
    private TypeOfEarPet typeOfEarPet;

    //шерсть
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfTypeWoolPet")
    @JsonBackReference
    private TypeOfWoolPet typeOfWoolPet;

    //причины выбытия из приюта
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfReasonToLeave")
    @JsonBackReference
    private ReasonToLeave reasonToLeave;

    //дата выбытия
    @Column(name = "dateOfLeave")
    private Date dateOfLeave;

    //причина выбытия
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfTypeOfTailPet")
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
