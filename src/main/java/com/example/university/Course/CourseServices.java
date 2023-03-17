package com.example.university.Course;

import com.example.university.Exception.CourseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServices {
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServices(CourseRepository courseRepository, CourseMapper courseMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }
    CourseDto saveCourse(CourseDto dto){
        courseRepository.findByCourseIgnoreCase(dto.getCourse())
                .ifPresent(course -> {throw new CourseException();
                });
        Course mapped = courseMapper.map(dto);
        Course save = courseRepository.save(mapped);
        return courseMapper.map(save);
    }
List<CourseDto>findAll(){
        return courseRepository.findAll().stream()
                .map(courseMapper::map).toList();
}
@Transactional
    public void deleteByCourse(String name){
        courseRepository.deleteByCourseIgnoreCase(name);
}
}
