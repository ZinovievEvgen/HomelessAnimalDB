package ru.jun.al.haz.homeless.animal.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

/**
 * Слой сущностей БД (Model)
 * класс-сотрудник: содержит информацию о сотрудниках
 * */
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "user_id")
    private Long id;

    @Column(name = "user_login")
    private String login;

    @Column(name = "user_password")
    private String password;

    @Email
    @Column(name = "user_email")
    private String email;

    @Column(name = "user_fio")
    private String fio;

    //если департамент - если префектура - если экспл организация - если приют (в контроллере при добавлени)

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    private List<Role> roles;
}
