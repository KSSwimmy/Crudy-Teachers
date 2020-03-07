package com.springrestapiapp.crudyteachers.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="teachers") // plural tables
public class Teacher // singular Classes
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long teacherid;

    @Column(unique = true,
            nullable = false)
    private String name;


    private String address;
    private String city;
    private String state;
    private String telephone;

    // One to many relationship - One teacher to many students
    @OneToMany(mappedBy = "teacher",
                orphanRemoval = true, // If there's a student not assigned to a teacher it gets removed.
                cascade = CascadeType.ALL) // If you worked with teacher then you'd also be able to work with students.
                                            // This is bridging teacher and student together
    private List<Student> students = new ArrayList<>();
}
