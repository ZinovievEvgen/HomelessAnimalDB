package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Слой сущностей БД (Model)
 * класс-Акт выбытия животного: содержит информацию о факте выбытия живовотного
 */
@Data
@Entity
@Table(name = "actOfLeave")
public class ActOfLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idOfActOfTransferOfPet")
    private Long idOfActOfTransferOfPet;

    //номер акта
    @Column(name = "numberActOfTransferOfPet")
    private String numberActOfTransferOfPet;

    //дата
    @Column(name = "dateOfActOfLeave")
    private Date dateOfActOfLeave;

    //причина
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reasonToLeaveId")
    @JsonBackReference
    private ReasonToLeave reasonToLeave;

    //карточка учета
    @OneToOne(mappedBy = "actOfLeaveOfPetId")
    private AccountCardOfPet accountCardOfPet;

    public ActOfLeave() {
    }
}
