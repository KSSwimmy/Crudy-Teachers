package com.springrestapiapp.crudyteachers.repos;
// This repo is an Interface. Not a Class


import com.springrestapiapp.crudyteachers.models.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Long>
{
    Teacher findByName(String name); //  findByName method was created here. Exposing it to the JPA
}

// Teacher is the class that CrudRepository takes on as a one of its params and it also takes on the datatype of the Id. Long is the class of the datatype.
