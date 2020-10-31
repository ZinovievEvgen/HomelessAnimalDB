package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс - причина движения: содержит информацию о причине движения
 */
@Data
@Entity
@Table(name = "reasonToLeave")
public class ReasonToLeave {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idOfReasonToLeave")
    private long idOfReasonToLeave;

    @Column(name = "nameOfReasonToLeave")
    private String nameOfReasonToLeave;

    @OneToMany(mappedBy = "reasonToLeave", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ActOfLeave> actOfLeave;

    public ReasonToLeave() {
    }
}
