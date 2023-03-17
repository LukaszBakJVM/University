package com.example.university.Student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentServices studentServices;

    public StudentController(StudentServices studentServices) {
        this.studentServices = studentServices;
    }
    @PostMapping()
    ResponseEntity<StudentDto>addStudent(@RequestBody StudentDto dto){
        StudentDto studentDto = studentServices.saveStudent(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(studentDto.getId()).toUri();
        return ResponseEntity.created(uri).body(studentDto);

    }
    @PutMapping("/{id}")
    ResponseEntity<?>update(@PathVariable long id ,@RequestBody StudentDto dto) {
        return studentServices.update(id,dto).map(u->ResponseEntity.noContent().build())
                .orElse(ResponseEntity.notFound().build());

    }
        @GetMapping
    ResponseEntity<List<StudentDto>>allStudents(@RequestParam(required = false) String lastName){
        if (lastName==null){
          return   ResponseEntity.ok(studentServices.allStudents());
        }
        return ResponseEntity.ok(studentServices.findAllByLastNameIgnoreCase(lastName));
    }
    @DeleteMapping("/{email}")
    ResponseEntity<?>deleteByEmail(@PathVariable String email){
        studentServices.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
