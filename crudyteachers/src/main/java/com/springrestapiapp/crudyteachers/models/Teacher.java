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

    public Teacher() // If you don't have this default constructor you'll get really weird error messages! TRUST ME YOU'LL NEED THIS!
    {
    }

    public Teacher(String name, String address, String city, String state, String telephone)
    {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
        // NOTICE: I didn't bring the list in. We just create constructors for the base fields.
    }

    public long getTeacherid()
    {
        return teacherid;
    }

    public void setTeacherid(long teacherid)
    {
        this.teacherid = teacherid;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public List<Student> getStudents()
    {
        return students;
    }

    public void setStudents(List<Student> students)
    {
        this.students = students;
    }
}
