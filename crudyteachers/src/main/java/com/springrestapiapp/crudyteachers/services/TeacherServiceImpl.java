package com.springrestapiapp.crudyteachers.services;

import com.springrestapiapp.crudyteachers.models.Student;
import com.springrestapiapp.crudyteachers.models.Teacher;
import com.springrestapiapp.crudyteachers.repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional //When there's a transactional inside the Class then you must make the entire Class transactional.
// Some people do this and some don't, but the way I was taught is how I'm going to do it. Especially if it prevents any errors.
// By all means, try it without it that's what you want!

@Service(value = "teacherService") //FYI: It likes double quotes.
public class TeacherServiceImpl implements TeacherService
{
    @Autowired //Letting @Autowired inject this field into teachrepos
    private TeacherRepository teachrepos;
    @Override
    public List<Teacher> findAll()
    {
       List<Teacher> rtnList = new ArrayList<>();
       teachrepos.findAll().iterator().forEachRemaining(rtnList::add);
       return rtnList;
    }

    @Override
    public Teacher findTeacherById(long id)
    {
        return null;
    }

    @Override
    public Teacher findTeacherByName(String name)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {

    }

    @Transactional //Running as a single transaction. Either it all works or it all fails.
    @Override
    public Teacher save(Teacher teacher)
    {
        Teacher newTeacher = new Teacher();

        newTeacher.setName((teacher.getName()));
        newTeacher.setAddress(teacher.getAddress());
        newTeacher.setCity(teacher.getCity());
        newTeacher.setState(teacher.getState());
        newTeacher.setTelephone(teacher.getTelephone());

        for (Student s : teacher.getStudents())
        {
            newTeacher.getStudents().add(new Student(s.getName(), s.getGrade(), newTeacher)); //adding a new student to teacher.
        }
        return teachrepos.save(newTeacher);
    }

    @Override
    public Teacher update(Teacher teacher, long id)
    {
        return null;
    }
}
