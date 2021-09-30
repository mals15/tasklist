package ru.mals.springboot.tasklist.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name="task", schema = "public", catalog = "tasklist_db")

@EqualsAndHashCode(of="id")
@Getter @Setter

@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate

public class Task {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private long Id;
    @Column (name="task_name")
    private String TaskName;
    @Column (name="sfera")
    private String Sfera;
    @Column (name="number_telephone")
    private String NumberTelephone;
    @Column (name="description")
    private String Description;
    @Column (name="adress")
    private String Adress;
    @Column (name="coordinates")
    private String Coordinates;
    @Column (name="conv_time")
    private String ConvTime;
    @Column (name="conv_date")
    private String ConvDate;
    @Column (name="person_name")
    private String PersonName;
    @Column (name="price")
    private String Price;

    @Override
    public String toString () {return TaskName;}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTaskName() {
        return TaskName;
    }

    public void setTaskName(String taskName) {
        TaskName = taskName;
    }

    public String getSfera() {
        return Sfera;
    }

    public void setSfera(String sfera) {
        Sfera = sfera;
    }

    public String getNumberTelephone() {
        return NumberTelephone;
    }

    public void setNumberTelephone(String numberTelephone) {
        NumberTelephone = numberTelephone;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getCoordinates() {
        return Coordinates;
    }

    public void setCoordinates(String coordinates) {
        Coordinates = coordinates;
    }

    public String getConvTime() {
        return ConvTime;
    }

    public void setConvTime(String convTime) {
        ConvTime = convTime;
    }

    public String getConvDate() {
        return ConvDate;
    }

    public void setConvDate(String convDate) {
        ConvDate = convDate;
    }

    public String getPersonName() {
        return PersonName;
    }

    public void setPersonName(String personName) {
        PersonName = personName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }



}
