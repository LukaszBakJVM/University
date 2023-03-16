package com.example.university.Teacher;

import org.springframework.stereotype.Service;

@Service
public class TeacherMapper {
    Teacher map (TeacherDto dto){
        Teacher teacher =new Teacher();
        teacher.setId(dto.getId());
        teacher.setFirstName(dto.getFirstName());
        teacher.setLastName(dto.getLastName());
        teacher.setEag(dto.getEag());
        teacher.setEmail(dto.getEmail());
        return teacher;
    }
    TeacherDto map (Teacher teacher){
        TeacherDto dto=new TeacherDto();
        dto.setId(teacher.getId());
        dto.setFirstName(teacher.getFirstName());
        dto.setLastName(teacher.getLastName());
        dto.setEag(teacher.getEag());
        dto.setEmail(teacher.getEmail());
        return dto;
    }

}
