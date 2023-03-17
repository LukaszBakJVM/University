package com.example.university.Subject;

import org.springframework.stereotype.Service;

@Service
public class SubjectMapper {
    Subject map (SubjectDto dto){
        Subject subject =new Subject();
        subject.setId(dto.getId());
        subject.setSubject(dto.getSubject());
        return subject;
    }
    SubjectDto map (Subject subject){
        SubjectDto dto =new SubjectDto();
        dto.setId(subject.getId());
        dto.setSubject(subject.getSubject());
        return dto;
    }
}
