package com.example.university.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Optional<Teacher>findByEmail(String email);
    List<Teacher>findAll();
    List<Teacher>findAllByLastNameContainingIgnoreCase(String lastName);
  Optional<Teacher>deleteByEmailIgnoreCase(String email);
}
