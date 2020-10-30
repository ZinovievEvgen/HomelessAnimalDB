package ru.jun.al.haz.homeless.animal.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Слой сущностей БД (Model)
 * класс-Акт ветеринарного осмотра: содержит информацию о факте ветеринарного осмотра животного специалистами
 */
@Data
@Entity
@Table(name = "actOfVetInspection")
public class ActOfVetInspection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfActOfVetInspection")
    private Long idOfActOfVetInspection;

    //дата
    @Column(name = "dateOfActOfVetInspection")
    private Date dateOfActOfVetInspection;

    @Column(name = "anamnesisOfActOfVetInspection")
    private String anamnesisOfActOfVetInspection;

    @OneToOne(mappedBy = "actOfVetInspectionOfPetId")
    private AccountCardOfPet accountCardOfPet;

    public ActOfVetInspection() {
    }
}
