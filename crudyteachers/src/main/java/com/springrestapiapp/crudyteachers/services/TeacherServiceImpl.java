package com.springrestapiapp.crudyteachers.services;

import com.springrestapiapp.crudyteachers.models.Student;
import com.springrestapiapp.crudyteachers.models.Teacher;
import com.springrestapiapp.crudyteachers.repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
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
        return teachrepos.findById(id) // checking to make sure the teacher exists.
                .orElseThrow(() -> new EntityNotFoundException("Id" + id));
    }

    @Override
    public Teacher findTeacherByName(String name)
    {
        Teacher teacher = teachrepos.findByName(name); // findByName was created in TeacherRepository.

        if (teacher == null)
        {
            throw new EntityNotFoundException("Teacher " + name + " not found!");
        }

        return teacher;
    }

    @Override
    public void delete(long id)
    {
        if (teachrepos.findById(id).isPresent())
        {
            teachrepos.deleteById(id);
        }
        else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
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
        Teacher currentTeacher = teachrepos.findById(id)
                                                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (teacher.getName() != null)
        {
            currentTeacher.setName(teacher.getName());
        }

        if (teacher.getAddress() != null)
        {
            currentTeacher.setAddress(teacher.getAddress());
        }

        if (teacher.getCity() != null)
        {
            currentTeacher.setCity(teacher.getCity());
        }

        if (teacher.getState() != null)
        {
            currentTeacher.setState(teacher.getState());
        }

        if (teacher.getTelephone() != null)
        {
            currentTeacher.setTelephone(teacher.getTelephone());
        }

        if (teacher.getStudents().size() > 0)
        {
            for (Student s : teacher.getStudents())
            {
                currentTeacher.getStudents().add(new Student(s.getName(), s.getGrade(), currentTeacher));
            }
        }

        return teachrepos.save(currentTeacher);
    }
}
