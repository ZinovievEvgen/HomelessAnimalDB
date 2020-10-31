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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfActOfLeave")
    private Long idOfActOfLeave;

    //номер акта
    @Column(name = "numberActOfLeave")
    private String numberActOfLeave;

    //дата
    @Column(name = "dateOfActOfLeave")
    private Date dateOfActOfLeave;

    //причина
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "reasonToLeaveId")
    @JsonBackReference
    private ReasonToLeave reasonToLeave;

    //карточка учета
    @OneToOne(mappedBy = "actOfLeave")
    private AccountCardOfPet accountCardOfPet;

    public ActOfLeave() {
    }
}
