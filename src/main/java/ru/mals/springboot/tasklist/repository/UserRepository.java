package ru.mals.springboot.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mals.springboot.tasklist.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
