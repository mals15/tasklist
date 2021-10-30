package ru.mals.springboot.tasklist.service.factory;

import org.springframework.stereotype.Component;
import ru.mals.springboot.tasklist.domain.Task;

@Component
public class TaskFactory {

    public Task build (String taskName,
                       String sfera,
                       String numberTelephone,
                       String description,
                       String adress,
                       String convTime,
                       String convDate,
                       String personName,
                       String price) {
        return new Task(taskName, sfera, numberTelephone, description, adress, convTime, convDate, personName, price);
    }

}
