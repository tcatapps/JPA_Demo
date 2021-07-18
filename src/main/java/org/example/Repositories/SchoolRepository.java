package org.example.Repositories;

import org.example.Models.School;
import org.example.Models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SchoolRepository {
    private EntityManager entityManager;
    private EntityManagerFactory emf;


    //A persistence unit defines the set of all entities
    //managed by a single entity manager in an application;
    public SchoolRepository() {
        this.emf = Persistence.createEntityManagerFactory("student_pu"); //pu = persistence unit
        this.entityManager = this.emf.createEntityManager();
    }

    public School addSchool(School school){
        entityManager.getTransaction().begin();
        entityManager.persist(school);
        entityManager.getTransaction().commit();
        return school;
    }

    public School findSchool(Long id){
        return entityManager.find(School.class, id);
    }

    public School update(School school){
        School oldSchool = findSchool(school.getId());
        entityManager.getTransaction().begin();
        oldSchool.setName(school.getName());
        oldSchool.setName(school.getCity());
        entityManager.getTransaction().commit();
        return oldSchool;
    }

    public void delete(School school){
        entityManager.getTransaction().begin();
        entityManager.remove(school);
        entityManager.getTransaction().commit();
    }

}
