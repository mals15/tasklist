package ru.mals.springboot.tasklist.service;

import ru.mals.springboot.tasklist.domain.Task;
import ru.mals.springboot.tasklist.dto.TaskCreateDto;
import ru.mals.springboot.tasklist.dto.TaskDto;
import ru.mals.springboot.tasklist.dto.TaskEditDto;

import java.util.List;

public interface TaskService {

    TaskDto getTask(long taskId);

    List<TaskDto> getAllTasks();

    TaskDto createTask(TaskCreateDto taskCreateDto);

    TaskDto editTask (Long taskId, TaskEditDto taskEditDto);

    void deleteTask (Task task);
}
