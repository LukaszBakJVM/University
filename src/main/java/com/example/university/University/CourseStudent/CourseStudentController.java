package com.example.university.University.CourseStudent;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/startCourse")
public class CourseStudentController {
    private final CourseStudentServices services;

    public CourseStudentController(CourseStudentServices services) {
        this.services = services;
    }

    @PostMapping
    ResponseEntity<CourseStudentDto> save(@RequestBody CourseStudentDto dto) {
        CourseStudentDto cs = services.startCurse(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(cs.getId()).toUri();
        return ResponseEntity.created(uri).body(cs);
    }
}