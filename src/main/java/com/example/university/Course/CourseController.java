package com.example.university.Course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    public final CourseServices courseServices;

    public CourseController(CourseServices courseServices) {
        this.courseServices = courseServices;
    }


    @PostMapping
    ResponseEntity<CourseDto>save(@RequestBody CourseDto dto){
        CourseDto courseDto = courseServices.saveCourse(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(courseDto.getId()).toUri();
        return ResponseEntity.created(uri).body(courseDto);

    }
    @GetMapping
    ResponseEntity<List<CourseDto>>findAll(){
        return ResponseEntity.ok(courseServices.findAll());

    }
    @DeleteMapping("/{name}")
    ResponseEntity<?>delete(@PathVariable String name){
        courseServices.deleteByCourse(name);
        return ResponseEntity.noContent().build();

    }

}
