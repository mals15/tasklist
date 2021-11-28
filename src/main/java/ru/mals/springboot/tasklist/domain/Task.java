package ru.mals.springboot.tasklist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
//@Table(name="task", schema = "tasklist", catalog = "tasklist_db")
@Table(name="t_task")
@Getter
@Setter
@EqualsAndHashCode(of="id")

@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate

public class Task {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private long id;
    private String taskName;
    private String sfera;
    private String numberTelephone;
    private String description;
    private String adress;
    private String convTime;
    private String convDate;
    private String personName;
    private String price;
    private long userId;

    public Task() {
    }

    public Task(String taskName,
                String sfera,
                String numberTelephone,
                String description,
                String adress,
                String convTime,
                String convDate,
                String personName,
                String price) {
        this.taskName = taskName;
        this.sfera = sfera;
        this.numberTelephone = numberTelephone;
        this.description = description;
        this.adress = adress;
        this.convTime = convTime;
        this.convDate = convDate;
        this.personName = personName;
        this.price = price;
    }

    @Override
    public String toString () {return taskName;}

}
