package com.springrestapiapp.crudyteachers.services;
// This repo is an Interface. Not a Class

//This is where we set up our controllers letting it know what it has access to.

import com.springrestapiapp.crudyteachers.models.Teacher;

import java.util.List;

public interface TeacherService
{
    List<Teacher> findAll();

    Teacher findTeacherById(long id);

    Teacher findTeacherByName(String name);

    void delete(long id);

    Teacher save(Teacher teacher);

    Teacher update(Teacher teacher, long id);

}
