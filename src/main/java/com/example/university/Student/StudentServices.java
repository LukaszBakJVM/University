package com.example.university.Student;

import com.example.university.Exception.EmailException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class StudentServices {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServices(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }
StudentDto saveStudent(StudentDto studentDto){
    studentRepository.findByEmail(studentDto.getEmail())
        .ifPresent(t->{throw new EmailException();
        });

    Student mapped = studentMapper.map(studentDto);
    Student save = studentRepository.save(mapped);
    return studentMapper.map(save);


     }
List<StudentDto>allStudents(){
        return studentRepository.findAll().stream().map(studentMapper::map).toList();
     }
List<StudentDto>findAllByLastNameIgnoreCase(String lastName){
        return studentRepository.findAllByLastNameContainingIgnoreCase(lastName)
                .stream().map(studentMapper::map).toList();
    }
@Transactional
public  void  deleteByEmail(String email){

      studentRepository.deleteByEmailIgnoreCase(email);

   }
}
