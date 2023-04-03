package com.example.university.University.TeacherSubject;

import com.example.university.Subject.Subject;
import com.example.university.Subject.SubjectRepository;
import com.example.university.Teacher.Teacher;
import com.example.university.Teacher.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherSubjectMapper {
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public TeacherSubjectMapper(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    TeacherSubjectDto map(TeacherSubjects subjects){
        TeacherSubjectDto dto=new TeacherSubjectDto();
        Subject subject=subjects.getSubject();
        Teacher teacher =subjects.getTeacher();
        dto.setId(subjects.getId());
        dto.setTeacherId(teacher.getId());
        dto.setSubjectId(subject.getId());
        return dto;


    }
  /*  TeacherSubjects map(TeacherSubjectDto dto){
        TeacherSubjects teacherSubjects =new TeacherSubjects();
        teacherSubjects.setId(dto.getId());
        Teacher teacher = teacherRepository.findById(dto.getTeacherId()).orElseThrow();
        teacherSubjects.setTeacher(teacher);
        Subject subject = subjectRepository.findById(dto.getSubjectId()).orElseThrow();
        teacherSubjects.setSubject(subject);
        return teacherSubjects;
    }*/
}
