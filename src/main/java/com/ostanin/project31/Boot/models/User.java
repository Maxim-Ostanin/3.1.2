package com.ostanin.project31.Boot.models;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;


    private String lastName;


    private int age;

    public User() {
    }

    public User(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last name='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
