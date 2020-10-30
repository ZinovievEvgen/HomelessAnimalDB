package ru.jun.al.haz.homeless.animal.models;

import lombok.Data;

import javax.persistence.*;

/**
 * Слой сущностей БД (Model)
 * класс-сотрудник: содержит информацию о сотрудниках
 * */
@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idOfEmployee")
    private Long idOfEmployee;

    //фио сотрудика
    @Column(name = "fioOfEmployee")
    private String fioOfEmployee;

    //если департамент - если префектура - если экспл организация - если приют (в контроллере при добавлени)
}
