package com.example.university;

import com.example.university.Student.Student;
import com.example.university.Student.StudentRepository;
import com.example.university.Student.StudentServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.xml.validation.Validator;
import java.util.List;

@SpringBootApplication
public class UniversityApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(UniversityApplication.class, args);
       // Validator validator =run.getBean(Validator.class);
        StudentServices studentRepository =run.getBean(StudentServices.class);

       // System.out.println(all);

    }

}
