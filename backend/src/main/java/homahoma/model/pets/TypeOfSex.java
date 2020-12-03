package homahoma.model.pets;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import homahoma.model.Pet;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-Тип пола животного: содержит информацию о типах (подтипах) пола животных
 */
@Entity
@Table(name = "type_of_sex")
public class TypeOfSex {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "typeOfSex", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets;

    public TypeOfSex() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "TypeOfSex{" +
                "name='" + name + '\'' +
                '}';
    }
}
