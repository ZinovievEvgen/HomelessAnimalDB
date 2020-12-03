package homahoma.model.pets;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import homahoma.model.Pet;

import javax.persistence.*;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс - Порода животного: содержит информацию о породах животных
 */
@Entity
@Table(name = "type_of_breed")
public class TypeOfBreed {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "breedOfPet", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Pet> pets;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_of_pet")
    @JsonBackReference
    private TypeOfPet typeOfPet;

    public TypeOfBreed() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeOfPet getTypeOfPet() {
        return typeOfPet;
    }

    public void setTypeOfPet(TypeOfPet typeOfPet) {
        this.typeOfPet = typeOfPet;
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
        return "TypeOfBreed{" +
                "name='" + name + '\'' +
                '}';
    }
}
