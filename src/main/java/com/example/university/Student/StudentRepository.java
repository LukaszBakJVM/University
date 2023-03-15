package com.example.university.Student;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,Long> {

    Optional<Student> findByEmail(String email);
    List<Student>findAll();
    List<Student>findAllByLastNameContainingIgnoreCase(String lastName);
    Optional<Student>deleteByEmailIgnoreCase(String email);
}
