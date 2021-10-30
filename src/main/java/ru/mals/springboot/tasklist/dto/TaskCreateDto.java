package ru.mals.springboot.tasklist.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TaskCreateDto {

    private String taskName;
    private String sfera;
    private String numberTelephone;
    private String description;
    private String adress;
    private String convTime;
    private String convDate;
    private String personName;
    private String price;
    public TaskCreateDto() {
    }
}
