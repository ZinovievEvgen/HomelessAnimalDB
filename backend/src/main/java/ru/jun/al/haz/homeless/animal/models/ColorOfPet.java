package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс - окрас животного: содержит информацию об окрасах животных
 */
@Data
@Entity
@Table(name = "colorOfPet")
public class ColorOfPet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idOfColorPets")
    private long idOfColorPet;

    @Column(name = "nameOfColorPet")
    private String nameOfColorPet;

    @OneToMany(mappedBy = "colorOfPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AccountCardOfPet> accountCardOfPet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfTypePets")
    @JsonBackReference
    private TypeOfPet typeOfPet;

    public ColorOfPet() {
    }
}
