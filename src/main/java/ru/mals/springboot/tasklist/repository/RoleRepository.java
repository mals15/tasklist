package ru.mals.springboot.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mals.springboot.tasklist.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
