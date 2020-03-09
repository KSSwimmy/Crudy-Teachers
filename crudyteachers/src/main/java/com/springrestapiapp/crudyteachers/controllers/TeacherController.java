package com.springrestapiapp.crudyteachers.controllers;
//A Class

import com.springrestapiapp.crudyteachers.models.Teacher;
import com.springrestapiapp.crudyteachers.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TeacherController
{
    @Autowired
    private TeacherService teacherService;

    // GET ALL ///////////////////////////////////////////////////////////////////////
    //http://localhost:2020/teachers/teachers
    @GetMapping(value = "/teachers/teachers",
                produces = {"application/json"})
    public ResponseEntity<?> listAllTeachers()
    {
        List<Teacher> myTeachers = teacherService.findAll();
        return new ResponseEntity<>(myTeachers, HttpStatus.OK);
    }

    // GET A TEACHER BY ID ///////////////////////////////////////////////////////////////////////
    // http://localhost:2020/teachers/teacher
    @GetMapping(value = "/teachers/teacher/{teacherId}", // {teacherId} means you'll be entering in an actual number in the API client.
                produces = {"application/json"})
    public ResponseEntity<?> getTeacherById(@PathVariable Long teacherId)
    {
        Teacher t = teacherService.findTeacherById(teacherId);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    // GET A TEACHER BY NAME ///////////////////////////////////////////////////////////////////////
    // http://localhost:2020/teachers/teacher
    @GetMapping(value = "/teachers/teacher/{teacherName}", // {teacherId} means you'll be entering in an actual number in the API client.
                produces = {"application/json"})
    public ResponseEntity<?> getTeacherByName(@PathVariable String teacherName)
    {
        Teacher t = teacherService.findTeacherByName(teacherName);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    // PUT - UPDATE TEACHER ///////////////////////////////////////////////////////////////////////
    // http://localhost:2020/teachers/teacher/{teacherId}
    @PutMapping(value = "/teachers/teacher/{teacherId}",
                produces = {"application/jason"},
                consumes = {"application/jason"})
    public ResponseEntity<?> updateTeacher(@RequestBody Teacher updateTeacher,
                                           @PathVariable
                                           long teacherId)
    {
        teacherService.update(updateTeacher, teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    // POST - ADD NEW TEACHER ///////////////////////////////////////////////////////////////////////
    // http://localhost:2020/teachers/teacher
    @PostMapping(value = "/teacher",
                 consumes = {"application/json"},
                 produces = {"application/json"})
    public ResponseEntity<?> addNewTeacher(@Valid
                                              @RequestBody
                                                       Teacher newTeacher) throws URISyntaxException
    {
        newTeacher = teacherService.save(newTeacher);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{teacherid}").buildAndExpand(newTeacher.getTeacherid()).toUri();
        responseHeaders.setLocation(newRestaurantURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    // DELETE A TEACHER ///////////////////////////////////////////////////////////////////////
    // http://localhost:2020/teachers/teacher/{teacherId}
    @DeleteMapping(value = "/teachers/teacher/{teacherId}")
    public ResponseEntity<?> deleteTeacherBy(@PathVariable long teacherId)
    {
        teacherService.delete(teacherId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
