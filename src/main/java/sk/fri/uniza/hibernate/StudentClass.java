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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 *
 * @author hudik1
 */
@Entity
public class StudentClass {

    public StudentClass(Long id) {
        this.id = id;
    }
    
    @Id
    @GeneratedValue
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }
    
    
}
