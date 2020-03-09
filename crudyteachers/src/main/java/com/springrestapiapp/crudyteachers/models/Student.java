package com.springrestapiapp.crudyteachers.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studentid;

    @Column(nullable = false)
    private String name;
    private double grade;

    @ManyToOne
    @JoinColumn(name = "teacherid", // this is the same teacherid in the Teacher class
                                    //JoinColumn connects them.
                nullable = false)

    @JsonIgnoreProperties("students")
    private Teacher teacher;

    public Student() // Every time we make a class that is going to be an entity we're going to have to
                    // create a default constructor because Spring Data JPA Requires it
    {
    }

    public Student(String name, double grade, Teacher teacher)
    {
        this.name = name;
        this.grade = grade;
        this.teacher = teacher;
    }

    public long getStudentid()
    {
        return studentid;
    }

    public void setStudentid(long studentid) // we need the setter for ID because we'll
                                            // need it for the dreadful seed data (My least favorite part to be honest 😩)
                                            // we want to have control over the id
    {
        this.studentid = studentid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getGrade()
    {
        return grade;
    }

    public void setGrade(double grade)
    {
        this.grade = grade;
    }

    public Teacher getTeacher()
    {
        return teacher;
    }

    public void setTeacher(Teacher teacher)
    {
        this.teacher = teacher;
    }
}

