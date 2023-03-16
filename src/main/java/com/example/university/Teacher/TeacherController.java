package com.example.university.Teacher;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherServices teacherServices;

    public TeacherController(TeacherServices teacherServices) {
        this.teacherServices = teacherServices;
    }

    @PutMapping
    ResponseEntity<TeacherDto> saveTeacher(@RequestBody TeacherDto dto) {
        TeacherDto teacherDto = teacherServices.saveTeacher(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(teacherDto.getId()).toUri();
        return ResponseEntity.created(uri).body(teacherDto);
    }

    @GetMapping
    ResponseEntity<List<TeacherDto>> allTeachers(@RequestParam(required = false) String lastName) {
        if (lastName == null) {
            return ResponseEntity.ok(teacherServices.findAll());
        }
        return ResponseEntity.ok(teacherServices.findAllByLastNameIgnoreCase(lastName));
    }

    ResponseEntity<?> deleteByEmail(@PathVariable String email) {
        teacherServices.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }
}