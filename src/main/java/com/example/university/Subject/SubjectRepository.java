package com.example.university.Subject;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends CrudRepository<Subject,Long> {
    List<Subject> findAll();
    Optional<Subject>findBySubjectIgnoreCase(String subject);
    Optional<Subject>deleteBySubjectIgnoreCase(String subject);
}
