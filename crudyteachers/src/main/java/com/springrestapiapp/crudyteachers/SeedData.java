package com.springrestapiapp.crudyteachers;

import com.springrestapiapp.crudyteachers.models.Student;
import com.springrestapiapp.crudyteachers.models.Teacher;
import com.springrestapiapp.crudyteachers.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//@Component
@Transactional // pick the @Transactional that's associated with the Spring Framework
public class SeedData implements CommandLineRunner
{
    @Autowired
    TeacherService teacherService;

    @Override
    public void run(String[] args) throws Exception
    {
        // Teacher String name, String address, String city, String state, String telephone
        String teach1Name = "John Mictchell";
        Teacher t1 = new Teacher(teach1Name,
                                       "123 Main Street",
                                       "City", "ST", "555-555-1234");
        t1.getStudents().add(new Student("Jason Belgard", 60.5, t1));
        t1.getStudents().add(new Student("Justin Trombley", 70.5, t1));
        t1.getStudents().add(new Student("Jose Montero", 90.7, t1));
        t1.getStudents().add(new Student("Donald Whitely ", 85.4, t1));
        t1.getStudents().add(new Student("Luis Ocasio", 44.5, t1));

        teacherService.save(t1);

        String teach2Name = "Dan Levy";
        Teacher t2 = new Teacher(teach2Name,
                                 "321 Uptown Drive",
                                 "Town", "ST", "555-555-5555");
        t2.getStudents().add(new Student("Doc Jones", 89.4, t2));
        t2.getStudents().add(new Student("Chad Kidd", 90.7, t2));
        t2.getStudents().add(new Student("Remington Shock", 90.7, t2));
        t2.getStudents().add(new Student("Rebecca Joyner", 90.7, t2));

        teacherService.save(t2);

        String teach3Name = "Dustin Myers";
        Teacher t3 = new Teacher(teach3Name,
                                       "565 Side Avenue",
                                       "Village", "ST", "555-123-1555");
        t3.getStudents().add(new Student("Adetunji Shennaike", 99.99, t3));
        t3.getStudents().add(new Student("Elan Riznis ", 89.99, t3));
        t3.getStudents().add(new Student("Stacy Williams", 100.01, t3));

        teacherService.save(t3);

    }
}
// The example names are real people. Look them up on LinkedIn and connect if you want to! :D