package ru.jun.al.haz.homeless.animal.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Слой сущностей БД (Model)
 * класс-Акт отлова животного: содержит информацию об фатке отлова животного
 */
@Data
@Entity
@Table(name = "actOfCatch")
public class ActOfCatch {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idOfActOfCatch")
    private Long idOfActOfCatch;

    // административный округ
    @Column(name = "districtOfCatch")
    private String districtOfCatch;

    //адресс места отлова
    @Column(name = "addressOnPlaceOfCatchPet")
    private String addressOnPlaceOfCatchPet;

    //номер акта
    @Column(name = "numberActOfCatchPet")
    private String numberActOfCatchPet;

    //карточка учета
    @OneToOne(mappedBy = "actOfLeaveOfPetId")
    private AccountCardOfPet accountCardOfPet;

    public ActOfCatch() {
    }
}
