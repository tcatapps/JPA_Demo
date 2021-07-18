package org.example;

import org.example.Models.School;
import org.example.Models.Student;
import org.example.Repositories.SchoolRepository;
import org.example.Repositories.StudentRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student();
        student.setFirstName("Alan");
        student.setLastName("Red");

        StudentRepository studentRepository = new StudentRepository();
        SchoolRepository schoolRepository = new SchoolRepository();

        studentRepository.addStudent(student);
        System.out.println("Added student " + student);

        School school = new School("school_1", "city_1");
        schoolRepository.addSchool(school);
        System.out.println("Added a new School to the db " + school);

        student = studentRepository.findStudent(student.getId());
        System.out.println("Found student " + student);

        student.setLastName("Green");
        studentRepository.update(student);
        System.out.println("Updated student " + student);

        studentRepository.delete(student);
        System.out.println("Deleted student " + student);

    }
}
