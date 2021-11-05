package ru.mals.springboot.tasklist.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name="user")
//@Table(name="user", schema = "tasklist", catalog = "tasklist_db")
@Getter
@Setter

@EqualsAndHashCode
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate

public class User {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    @Column(name="name")
    private String name;
    @Column(name="numb_tel")
    private String numbTel;
    @Column(name="email")
    private String email;

}
