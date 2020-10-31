package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-префектуры: содержит информацию о префектурах
 */
@Data
@Entity
@Table(name = "prefect")
public class Prefect {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idOfPrefect")
    private Long idOfPrefect;

    @Column(name = "nameOfPrefect")
    private String nameOfPrefect;

    @OneToMany(mappedBy = "prefect", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ExploitingOrganization> exploitingOrganization;

    public Prefect() {
    }
}
