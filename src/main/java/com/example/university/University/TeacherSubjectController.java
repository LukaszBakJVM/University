package com.example.university.University;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/asigments")
public class TeacherSubjectController {
    private final TeacherSubjectServices services;

    public TeacherSubjectController(TeacherSubjectServices services) {
        this.services = services;
    }
   @PostMapping
    ResponseEntity<TeacherSubjectDto>save(@RequestBody TeacherSubjectDto dto){
        TeacherSubjectDto subject = services.createSubject(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(subject.getId()).toUri();
        return ResponseEntity.created(uri).body(subject);
    }
    @GetMapping("/{id}")
    ResponseEntity<List<TeacherSubjectDto>>allTeacherSubjects(@PathVariable long id){
return ResponseEntity.ok(services.findAllTeacherSubjects(id));

    }


}
