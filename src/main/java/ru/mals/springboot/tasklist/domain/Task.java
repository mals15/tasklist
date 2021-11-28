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
    @Column (name="task_name")
    private String taskName;
    @Column (name="sfera")
    private String sfera;
    @Column (name="number_telephone")
    private String numberTelephone;
    @Column (name="description")
    private String description;
    @Column (name="adress")
    private String adress;
    @Column (name="conv_time")
    private String convTime;
    @Column (name="conv_date")
    private String convDate;
    @Column (name="person_name")
    private String personName;
    @Column (name="price")
    private String price;

    private long userid;

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
