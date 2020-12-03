package homahoma.model.pets;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import homahoma.model.Pet;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Тип животного: содержит информацию о типах (подтипах) животных
 */
@Entity
@Table(name = "type_of_pet")
public class TypeOfPet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "typeOfPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets;

    @OneToMany(mappedBy = "typeOfPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TypeOfBreed> typeOfBreedList;

    public TypeOfPet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TypeOfBreed> getTypeOfBreedList() {
        return typeOfBreedList;
    }

    public void setTypeOfBreedList(List<TypeOfBreed> typeOfBreedList) {
        this.typeOfBreedList = typeOfBreedList;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeOfPet{" +
                "name='" + name + '\'' +
                '}';
    }
}
