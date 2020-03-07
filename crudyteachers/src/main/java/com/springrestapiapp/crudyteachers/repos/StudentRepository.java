package com.springrestapiapp.crudyteachers.repos;
// This repo is an Interface. Not a Class

import com.springrestapiapp.crudyteachers.models.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>
{
}

// Student is the class that CrudRepository takes on as a one of its params and it also takes on the datatype of the Id. Long is the class of the datatype.
