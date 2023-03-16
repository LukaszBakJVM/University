package com.example.university.Subject;

import com.example.university.Course.Course;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    @Column (unique = true)
    private String subject;
  //  @ManyToMany
 //   @JoinColumn(name = "Kierunek",referencedColumnName = "course")
   // private List<Course>courses=new ArrayList<>();



    public Subject() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


}
