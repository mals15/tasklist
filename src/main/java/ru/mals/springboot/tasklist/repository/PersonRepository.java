package ru.mals.springboot.tasklist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mals.springboot.tasklist.domain.User;

@Repository
public interface PersonRepository extends JpaRepository<User, Long> {

//    Optional<Person> findByEmail(String email);

}
