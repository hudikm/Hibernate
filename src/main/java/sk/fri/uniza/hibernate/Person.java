/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

/**
 *
 * @author hudik1
 */
@Entity
@Table(name = "Persons")
@Inheritance
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private Integer age;

    public Person(Integer id, String firstName, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.age = age;
    }

    public Person(String firstName, Integer age) {
        this.firstName = firstName;
        this.age = age;
    }

    public Person() {
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
