/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    public StudentClass(String nameOfClass) {
        this.nameOfClass = nameOfClass;
    }

    String nameOfClass;

    StudentClass() {

    }

    public String getNameOfClass() {
        return nameOfClass;
    }

    public void setNameOfClass(String nameOfClass) {
        this.nameOfClass = nameOfClass;
    }

    @OneToMany(mappedBy = "studentClass", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student> students = new ArrayList<>();

    @ManyToMany(mappedBy = "studentClassesLecturer")
    private List<Lecturer> lecturers = new ArrayList<>();

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setStudentClass(this);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.nameOfClass);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StudentClass other = (StudentClass) obj;
        if (!Objects.equals(this.nameOfClass, other.nameOfClass)) {
            return false;
        }
        return true;
    }

}
