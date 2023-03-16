package com.example.university.Teacher;

public class TeacherDto {
    private long id;
    private String firstName;
    private String lastName;
    //  @Min(18)
    private int eag;
    private String email;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEag() {
        return eag;
    }

    public void setEag(int eag) {
        this.eag = eag;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
