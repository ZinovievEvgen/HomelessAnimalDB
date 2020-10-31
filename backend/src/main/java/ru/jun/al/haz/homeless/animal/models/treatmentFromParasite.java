package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Слой сущностей БД (Model)
 * класс-вакцинация животных: содержит информацию о вакцинации животных
 */
@Data
@Entity
@Table(name = "treatmentFromParasite")
public class TreatmentFromParasite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfTreatmentFromParasite")
    private Long idOfTreatmentFromParasite;

    //номер
    @Column(name = "numberTreatmentFromParasite")
    private String numberTreatmentFromParasite;

    //дата
    @Column(name = "dateOfTreatmentFromParasite")
    private Date dateOfTreatmentFromParasite;

    //лекарство
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfMedicament")
    @JsonBackReference
    private Medicament medicament;

    //доза
    @Column(name = "rangeOfTreatmentFromParasite")
    private Double rangeOfTreatmentFromParasite;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfAccountCardOfPet")
    @JsonBackReference
    private AccountCardOfPet accountCardOfPet;

    public TreatmentFromParasite() {
    }
}
