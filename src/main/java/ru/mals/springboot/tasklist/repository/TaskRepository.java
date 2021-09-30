package ru.mals.springboot.tasklist.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mals.springboot.tasklist.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {

}
