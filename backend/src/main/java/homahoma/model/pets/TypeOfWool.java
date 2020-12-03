package homahoma.model.pets;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import homahoma.model.Pet;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс - тип шерсти животного: содержит информацию о типах шерсти животных
 */
@Entity
@Table(name = "type_of_wool")
public class TypeOfWool {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "typeOfWool", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets;

    public TypeOfWool() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "TypeOfWool{" +
                "name='" + name + '\'' +
                '}';
    }
}
