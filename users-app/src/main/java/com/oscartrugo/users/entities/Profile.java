package com.oscartrugo.users.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private Integer firstName;

    @Column(name = "last_name")
    private Integer lastName;

    @Column(name = "birt_date")
    private Date birthDate;
}
