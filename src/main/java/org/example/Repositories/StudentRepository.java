package org.example.Repositories;

import org.example.Models.School;
import org.example.Models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class StudentRepository {

    private EntityManager entityManager;
    private EntityManagerFactory emf;


    public StudentRepository() {
        this.emf = Persistence.createEntityManagerFactory("student_pu"); //pu = persistence unit
        this.entityManager = this.emf.createEntityManager();
    }

    public Student addStudent(Student student){
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }

    public Student findStudent(Long id){
        return entityManager.find(Student.class, id);
    }

    public Student update(Student student){
        Student oldStudent = entityManager.find(Student.class, student.getId());

        entityManager.getTransaction().begin();

        oldStudent.setFirstName(student.getFirstName());
        oldStudent.setLastName(student.getLastName());

        entityManager.getTransaction().commit();

        return oldStudent;
    }

    public void delete(Student student){
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }

    public void close(){
        this.entityManager.close();
        this.emf.close();
    }

    public List<String> findFirstNames(){
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select s.firstName from Student s");

        return query.getResultList();
    }

    public Student addSchool(Long id, School school){
        entityManager.getTransaction().begin();
        Student student = findStudent(id);
        student.setSchool(school);
        entityManager.getTransaction().commit();
        return student;
    }
}
