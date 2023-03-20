package com.example.university.Course;


import org.springframework.data.jpa.repository.JpaRepository;



import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course>findAllByOrderByIdAsc() ;



    Optional<Course> findByCourseIgnoreCase(String course);
    Optional<Course>deleteByCourseIgnoreCase(String course);
}
