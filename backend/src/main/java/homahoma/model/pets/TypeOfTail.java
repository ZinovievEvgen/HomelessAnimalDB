package homahoma.model.pets;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import homahoma.model.Pet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс - Тип хвостов животных: содержит информацию о типах (подтипах) хвостов животных
 */
@Entity
@Table(name = "type_of_tail")
public class TypeOfTail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private long id;

    @Column(name = "nameOfTypeOfTailPet")
    private String nameOfTypeOfTailPet;

    @OneToMany(mappedBy = "typeOfTail", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets;

    public TypeOfTail() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public String getNameOfTypeOfTailPet() {
        return nameOfTypeOfTailPet;
    }

    public void setNameOfTypeOfTailPet(String nameOfTypeOfTailPet) {
        this.nameOfTypeOfTailPet = nameOfTypeOfTailPet;
    }

    @Override
    public String toString() {
        return "TypeOfTail{" +
                "nameOfTypeOfTailPet='" + nameOfTypeOfTailPet + '\'' +
                '}';
    }
}
