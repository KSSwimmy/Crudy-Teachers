package com.springrestapiapp.crudyteachers.models;


import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long menuid;

    @Column(nullable = false)
    private String name;
    private double grade;

    @ManyToOne
    @JoinColumn(name = "teacherid", // this is the same teacherid in the Teacher class
                                    //JoinColumn connects them.
                nullable = false)
    private Teacher teacher;
}
