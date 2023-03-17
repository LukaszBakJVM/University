package com.example.university.Subject;

import com.example.university.Student.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectServices subjectServices;

    public SubjectController(SubjectServices subjectServices) {
        this.subjectServices = subjectServices;
    }
    @PostMapping
    ResponseEntity<SubjectDto>addSubject(@RequestBody SubjectDto dto){
        SubjectDto subjectDto = subjectServices.saveSubject(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(subjectDto.getId()).toUri();
        return ResponseEntity.created(uri).body(subjectDto);

    }
    @GetMapping
    ResponseEntity<List<SubjectDto>>allSubject(){
        return ResponseEntity.ok(subjectServices.findAll());
    }
    @DeleteMapping("/{name}")
    ResponseEntity<?>deleteSubject(@PathVariable String name){
        subjectServices.deleteByName(name);
        return ResponseEntity.noContent().build();
    }
}
