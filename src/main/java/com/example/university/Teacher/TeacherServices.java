package com.example.university.Teacher;

import com.example.university.Exception.EmailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServices {
    private final TeacherRepository teacherRepository;
   private final TeacherMapper teacherMapper;

    public TeacherServices(TeacherRepository teacherRepository, TeacherMapper teacherMapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
    }
    TeacherDto saveTeacher(TeacherDto teacherDto){
        teacherRepository.findByEmail(teacherDto.getEmail())
                .ifPresent(teacher -> {throw new EmailException();
                });
        Teacher maped = teacherMapper.map(teacherDto);
        Teacher save = teacherRepository.save(maped);
        return teacherMapper.map(save);
    }

    List<TeacherDto>findAll(){
        return teacherRepository.findAll().stream().map(teacherMapper::map).toList();
    }
    List<TeacherDto>findAllByLastNameIgnoreCase(String lastName){
      return   teacherRepository.findAllByLastNameContainingIgnoreCase(lastName)
                .stream().map(teacherMapper::map).toList();
    }
    @Transactional
    public void  deleteByEmail(String email){
        teacherRepository.deleteByEmailIgnoreCase(email);
    }
}
