package com.example.university.University.TeacherSubject;

import com.example.university.Subject.Subject;
import com.example.university.Subject.SubjectRepository;
import com.example.university.Teacher.Teacher;
import com.example.university.Teacher.TeacherRepository;
import com.example.university.University.TeacherSubject.TeacherSubjectDto;
import com.example.university.University.TeacherSubject.TeacherSubjectMapper;
import com.example.university.University.TeacherSubject.TeacherSubjectRepository;
import com.example.university.University.TeacherSubject.TeacherSubjects;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherSubjectServices {
   private final TeacherRepository teacherRepository;
   private final SubjectRepository subjectRepository;
   private final TeacherSubjectRepository teacherSubjectRepository;
   private final TeacherSubjectMapper teacherSubjectMapper;


    public TeacherSubjectServices(TeacherRepository teacherRepository, SubjectRepository subjectRepository
            , TeacherSubjectRepository teacherSubjectRepository, TeacherSubjectMapper teacherSubjectMapper) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
        this.teacherSubjectRepository = teacherSubjectRepository;
        this.teacherSubjectMapper = teacherSubjectMapper;
    }
   TeacherSubjectDto createSubject(TeacherSubjectDto dto){
        TeacherSubjects teacherSubjects=new TeacherSubjects();
        Optional<Teacher> teacher = teacherRepository.findById(dto.getTeacherId());
        Optional<Subject> subject = subjectRepository.findById(dto.getSubjectId());
        teacherSubjects.setTeacher(teacher.orElseThrow());
        teacherSubjects.setSubject(subject.orElseThrow());
        return teacherSubjectMapper.map(teacherSubjectRepository.save(teacherSubjects));

    }
    List<TeacherSubjectDto> findAllTeacherSubjects(long id){
        return teacherSubjectRepository.findAllByTeacherId(id)
                .stream().map(teacherSubjectMapper::map).toList();
    }
}
