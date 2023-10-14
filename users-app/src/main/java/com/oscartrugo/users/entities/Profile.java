package com.oscartrugo.users.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFirstName() {
        return firstName;
    }

    public void setFirstName(Integer firstName) {
        this.firstName = firstName;
    }

    public Integer getLastName() {
        return lastName;
    }

    public void setLastName(Integer lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
