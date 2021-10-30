package ru.mals.springboot.tasklist.dto;

import lombok.Getter;

@Getter
public class TaskEditDto {

    private final String taskName;
    private final String sfera;
    private final String numberTelephone;
    private final String description;
    private final String adress;
    private final String convTime;
    private final String convDate;
    private final String personName;
    private final String price;

    public TaskEditDto(String taskName,
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
}
