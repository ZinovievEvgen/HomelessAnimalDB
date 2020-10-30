package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-вакцинация животных: содержит информацию о вакцинации животных
 */
@Data
@Entity
@Table(name = "vaccinationOfPet")
public class VaccinationOfPet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfVaccinationOfPet")
    private Long idOfVaccinationOfPet;

    //номер
    @Column(name = "numberVaccinationOfPet")
    private String numberVaccinationOfPet;

    //дата
    @Column(name = "dateOfVaccinationOfPet")
    private Date dateOfVaccinationOfPet;

    //лекарство
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medicamentId")
    @JsonBackReference
    private Medicament medicament;

    //карточка учета
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = AccountCardOfPet.class)
    @JoinTable(name = "vaccinationOfPets",
            joinColumns = {@JoinColumn(name = "vaccination_id")},
            inverseJoinColumns = {@JoinColumn(name = "accountCard_id")})
    @JsonBackReference
    private List<AccountCardOfPet> accountCardOfPetList;

    public VaccinationOfPet() {
    }
}
