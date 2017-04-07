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

    public Student(Date dateOfStart,String firstName, Integer age) {
        super(firstName, age);
        this.dateOfStart = dateOfStart;
    }


    @ManyToOne
    private StudentClass studentClass;

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    @Temporal(TemporalType.DATE)
    Date dateOfStart;

}
