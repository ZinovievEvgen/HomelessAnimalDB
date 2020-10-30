package ru.jun.al.haz.homeless.animal.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Приют для животных: содержит информацию о приютах для животных
 */
@Data
@Entity
@Table(name = "sheltersOfPets")
public class ShelterOfPet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfShelterOfPet")
    private Long idOfShelterOfPet;

    //название приюта
    @Column(name = "nameOfShelterOfPet")
    private String nameOfShelterOfPet;

    //адрес приюта
    @Column(name = "addressOfShelterOfPet")
    private String addressOfShelterOfPet;

    //начальник приюта
    @Column(name = "chiefOfShelterOfPet")
    private String chiefOfShelterOfPet;

    //почтовый адрес
    @Column(name = "emailOfShelterOfPet")
    private String emailOfShelterOfPet;

    //телефон
    @Column(name = "phoneOfShelterOfPet")
    private String phoneOfShelterOfPet;

    //веб-сайт
    @Column(name = "urlOfShelterOfPet")
    private String urlOfShelterOfPet;

    //животные
    @OneToMany(mappedBy = "shelterOfPetId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets;

    //орг-штатная структура - у кого в подчинении
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exploitingOrganizationId")
    @JsonBackReference
    private String exploitingOrganization;

    public ShelterOfPet() {
    }
}
