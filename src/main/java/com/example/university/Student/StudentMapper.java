package com.example.university.Student;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    Student map(StudentDto dto){
        Student student =new Student();
        student.setId(dto.getId());
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEag(dto.getEag());
        student.setEmail(dto.getEmail());
      //  student.setFieldOfStudy(dto.getFieldOfStudy());
        return student;
    }
    StudentDto map(Student student){
        StudentDto studentDto =new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setEag(student.getEag());
        studentDto.setEmail(student.getEmail());
       // studentDto.setFieldOfStudy(student.getFieldOfStudy());
        return studentDto;
    }
}
