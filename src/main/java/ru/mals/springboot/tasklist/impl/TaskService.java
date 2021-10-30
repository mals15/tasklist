package ru.mals.springboot.tasklist.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mals.springboot.tasklist.dao.TaskDao;
import ru.mals.springboot.tasklist.domain.Task;
import ru.mals.springboot.tasklist.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskDao {

    private final TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List getAll() {
        return taskRepository.findAll();
    }

    @Override
    public List getAll(Sort sort) {
        return taskRepository.findAll(sort);
    }

    @Override
    public List search(String... searchString) {
        return null;
    }

    @Override
    public Task get(long id){
        Optional<Task> bookmark = taskRepository.findById(id); // Optional - обертка, в котором может быть значение или пусто (используется для исключение ошибки NullPointerException
        if (bookmark.isPresent()) {  // если значение представлено - вернуть его
            return bookmark.get();
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public void delete(Task task) {
        taskRepository.delete(task);
    }

    @Override
    public Page getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return null;
    }

    @Override
    public Page search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }
}
