package ru.mals.springboot.tasklist.service.mapper;

import org.springframework.stereotype.Component;
import ru.mals.springboot.tasklist.domain.Task;
import ru.mals.springboot.tasklist.dto.TaskDto;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskMapper {

    public TaskDto mapTaskToTaskDto(Task model) {
        return new TaskDto(
                model.getId(),
                model.getTaskName(),
                model.getSfera(),
                model.getNumberTelephone(),
                model.getDescription(),
                model.getConvTime(),
                model.getConvDate(),
                model.getConvDate(),
                model.getPersonName(),
                model.getPrice()
        );
    }

    public List<TaskDto> mapTaskToTaskDto (Collection<Task> model) {
        return model.stream()
                .map(this::mapTaskToTaskDto)
                .collect(Collectors.toList());
    }
}
