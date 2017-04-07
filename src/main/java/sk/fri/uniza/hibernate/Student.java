/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.hibernate;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author hudik1
 */
@Entity
public class Student extends Person {

    public Student() {
        super();
    }

    
    public Student(Integer id, String firstName, Integer age) {
        super(id, firstName, age);
    }

    public Student(Date dateOfStart, String firstName, Integer age) {
        super(firstName, age);
        this.dateOfStart = dateOfStart;
    }

    public Student(String firstName, Integer age) {
        super(firstName, age);
    }

    @Temporal(TemporalType.DATE)
    Date dateOfStart;

}
