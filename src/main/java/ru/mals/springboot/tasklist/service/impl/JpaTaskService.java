package ru.mals.springboot.tasklist.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mals.springboot.tasklist.domain.Task;
import ru.mals.springboot.tasklist.dto.TaskCreateDto;
import ru.mals.springboot.tasklist.dto.TaskDto;
import ru.mals.springboot.tasklist.dto.TaskEditDto;
import ru.mals.springboot.tasklist.repository.TaskRepository;
import ru.mals.springboot.tasklist.service.TaskService;
import ru.mals.springboot.tasklist.service.factory.TaskFactory;
import ru.mals.springboot.tasklist.service.mapper.TaskMapper;

import java.util.List;

@Service
public class JpaTaskService implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final TaskFactory taskFactory;

    public JpaTaskService(TaskRepository taskRepository,
                          TaskMapper taskMapper,
                          TaskFactory taskFactory) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
        this.taskFactory = taskFactory;
    }

    @Override
    public TaskDto getTask(long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(); // Optional - обертка, в котором может быть значение или пусто (используется для исключение ошибки NullPointerException
            return taskMapper.mapTaskToTaskDto(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return taskMapper.mapTaskToTaskDto(tasks);
    }

    @Override
    public TaskDto createTask(TaskCreateDto taskCreateDto) {
        Task task = taskFactory.build(
                taskCreateDto.getTaskName(),
                taskCreateDto.getSfera(),
                taskCreateDto.getNumberTelephone(),
                taskCreateDto.getDescription(),
                taskCreateDto.getAdress(),
                taskCreateDto.getConvTime(),
                taskCreateDto.getConvDate(),
                taskCreateDto.getPersonName(),
                taskCreateDto.getPrice()
        );
        task = taskRepository.saveAndFlush(task);
        return taskMapper.mapTaskToTaskDto(task);
    }

    @Override
    public TaskDto editTask(long taskId, TaskEditDto taskEditDto) {
        Task task = taskRepository.findById(taskId).orElseThrow();
        task.setTaskName(taskEditDto.getTaskName());
        task.setSfera(taskEditDto.getSfera());
        task.setNumberTelephone(taskEditDto.getNumberTelephone());
        task.setDescription(taskEditDto.getDescription());
        task.setConvTime(taskEditDto.getConvTime());
        task.setConvDate(taskEditDto.getConvDate());
        task.setPersonName(taskEditDto.getPersonName());
        task.setPrice(taskEditDto.getPrice());

        taskRepository.saveAndFlush(task);
        return taskMapper.mapTaskToTaskDto(task);
    }

    @Override
    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }
}
