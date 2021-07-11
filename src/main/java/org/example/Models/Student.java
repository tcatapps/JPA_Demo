package org.example.Models;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "student")
public @Data class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;


    public Student() {
    }


}
