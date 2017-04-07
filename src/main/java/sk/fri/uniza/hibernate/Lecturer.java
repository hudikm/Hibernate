/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.hibernate;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author hudik1
 */

@Entity
public class Lecturer extends Person {

    public Lecturer(Integer id, String firstName, Integer age) {
        super(id, firstName, age);
    }

    public Lecturer(String Department, String firstName, Integer age) {
        super(firstName, age);
        this.Department = Department;
    }

    public Lecturer(String firstName, Integer age) {
        super(firstName, age);
    }
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<StudentClass> studentClassesLecturer = new ArrayList<>();

    String Department;
    

}
