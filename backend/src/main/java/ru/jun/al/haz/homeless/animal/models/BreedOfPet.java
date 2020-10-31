package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс - Порода животного: содержит информацию опородах животных
 */
@Data
@Entity
@Table(name = "breedOfPet")
public class BreedOfPet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "idOfBreedPets")
    private long idOfBreedOfPet;

    @Column(name = "nameOfBreedOfPet")
    private String nameOfBreedOfPet;

    @OneToMany(mappedBy = "breedOfPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOfTypePets")
    @JsonBackReference
    private TypeOfPet typeOfPet;

    public BreedOfPet() {
    }
}
