package com.springrestapiapp.crudyteachers.services;

import com.springrestapiapp.crudyteachers.models.Teacher;
import com.springrestapiapp.crudyteachers.repos.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "teacherService") //FYI: It likes double quotes.
public class TeacherServiceImpl implements TeacherService
{
    @Autowired //Letting @Autowired inject this field into teahrepos
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

    @Override
    public Teacher save(Teacher teacher)
    {
        return null;
    }

    @Override
    public Teacher update(Teacher teacher, long id)
    {
        return null;
    }
}
