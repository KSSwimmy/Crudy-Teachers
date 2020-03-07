package com.springrestapiapp.crudyteachers.controllers;
//A Class

import com.springrestapiapp.crudyteachers.models.Teacher;
import com.springrestapiapp.crudyteachers.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    //http://localhost:2020/teachers/teachers
    @GetMapping(value = "/teachers/teachers",
                produces = {"application/json"})
    public ResponseEntity<?> listAllTeachers()
    {
        List<Teacher> myTeachers = teacherService.findAll();
        return new ResponseEntity<>(myTeachers, HttpStatus.OK);
    }
}
