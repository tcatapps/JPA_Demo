package org.example;

import org.example.Models.Student;
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

        StudentRepository repository = new StudentRepository();

        repository.addStudent(student);
        System.out.println("Added student " + student);

        student = repository.findStudent(student.getId());
        System.out.println("Found student " + student);

        student.setLastName("Green");
        repository.update(student);
        System.out.println("Updated student " + student);

        repository.delete(student);
        System.out.println("Deleted student " + student);

    }
}
