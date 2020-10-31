package ru.jun.al.haz.homeless.animal.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Слой сущностей БД (Model)
 * класс-Акт поступления животного: содержит информацию о факте поступления живовотного
 */
@Data
@Entity
@Table(name = "actOfTransfer")
public class ActOfTransfer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idOfActOfTransferOfPet")
    private Long idOfActOfTransferOfPet;

    //номер акта
    @Column(name = "numberActOfTransferOfPet")
    private String numberActOfTransferOfPet;

    //дата
    @Column(name = "dateOfActOfTransfer")
    private Date dateOfActOfTransfer;

    //карточка учета
    @OneToOne(mappedBy = "actOfTransferOfPetId")
    private AccountCardOfPet accountCardOfPet;

    public ActOfTransfer() {
    }
}
