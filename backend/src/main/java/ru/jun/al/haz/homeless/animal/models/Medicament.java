package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-медикаменты: содержит информацию о медикаментах
 */
@Data
@Entity
@Table(name = "medicament")
public class Medicament {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfMedicament")
    private Long idOfMedicament;

    //номер
    @Column(name = "numberSeriesMedicament")
    private String numberSeriesMedicament;

    @Column(name = "countMedicament")
    private Long countMedicament;

    @OneToMany(mappedBy = "medicament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<VaccinationOfPet> vaccinationOfPet;

    @OneToMany(mappedBy = "medicament", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TreatmentFromParasite> treatmentFromParasite;

    public Medicament() {
    }
}
