package homahoma.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import homahoma.model.pets.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Слой сущностей БД (Model)
 * класс - Животные: содержит информацию, ссылки на документы о животных и т.д.
 * <p>
 * typeOfBreed - порода
 * typeOfSex - пол
 * typeOfColor - окрас
 * typeOfEar - ушки
 * typeOfWool - шерстка
 * typeOfTail - хвостэ
 * <p>
 * status - статус актуальности записи (may be true - 1/ false - 0)
 */
@Entity
@Table(name = "pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_of_breed")
    @JsonBackReference
    private TypeOfBreed typeOfBreed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_of_pet")
    @JsonBackReference
    private TypeOfPet typeOfPet;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_of_sex")
    @JsonBackReference
    private TypeOfSex typeOfSex;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_of_color")
    @JsonBackReference
    private TypeOfColor typeOfColor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_of_ear")
    @JsonBackReference
    private TypeOfEar typeOfEar;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_of_wool")
    @JsonBackReference
    private TypeOfWool typeOfWool;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_type_of_tail")
    @JsonBackReference
    private TypeOfTail typeOfTail;

    @Column(name = "path_Of_photo")
    private String pathOfPhoto;

    @Column(name = "age")
    private Double age;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "sign")
    private List<String> sign;

    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createedDate;

    @Column(name = "status")
    private Long status;

    //controlSumHash

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user")
    @JsonBackReference
    private User person;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_of_shelter")
    @JsonBackReference
    private Shelter shelter;

    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getPerson() {
        return person;
    }

    public void setPerson(User person) {
        this.person = person;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public LocalDateTime getCreateedDate() {
        return createedDate;
    }

    public void setCreateedDate(LocalDateTime createedDate) {
        this.createedDate = createedDate;
    }

    public List<String> getSign() {
        return sign;
    }

    public void setSign(List<String> sign) {
        this.sign = sign;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getPathOfPhoto() {
        return pathOfPhoto;
    }

    public void setPathOfPhoto(String pathOfPhoto) {
        this.pathOfPhoto = pathOfPhoto;
    }

    public TypeOfWool getTypeOfWool() {
        return typeOfWool;
    }

    public void setTypeOfWool(TypeOfWool typeOfWool) {
        this.typeOfWool = typeOfWool;
    }

    public TypeOfTail getTypeOfTail() {
        return typeOfTail;
    }

    public void setTypeOfTail(TypeOfTail typeOfTail) {
        this.typeOfTail = typeOfTail;
    }

    public TypeOfEar getTypeOfEar() {
        return typeOfEar;
    }

    public void setTypeOfEar(TypeOfEar typeOfEar) {
        this.typeOfEar = typeOfEar;
    }

    public TypeOfColor getTypeOfColor() {
        return typeOfColor;
    }

    public void setTypeOfColor(TypeOfColor typeOfColor) {
        this.typeOfColor = typeOfColor;
    }

    public TypeOfSex getTypeOfSex() {
        return typeOfSex;
    }

    public void setTypeOfSex(TypeOfSex typeOfSex) {
        this.typeOfSex = typeOfSex;
    }

    public TypeOfPet getTypeOfPet() {
        return typeOfPet;
    }

    public void setTypeOfPet(TypeOfPet typeOfPet) {
        this.typeOfPet = typeOfPet;
    }

    public TypeOfBreed getTypeOfBreed() {
        return typeOfBreed;
    }

    public void setTypeOfBreed(TypeOfBreed typeOfBreed) {
        this.typeOfBreed = typeOfBreed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}
