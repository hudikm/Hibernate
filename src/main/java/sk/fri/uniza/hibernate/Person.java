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
import javax.persistence.Inheritance;
import static javax.persistence.InheritanceType.SINGLE_TABLE;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author hudik1
 */
@Entity
@Table(name = "Persons")
@Inheritance(strategy = SINGLE_TABLE) //Urcuje strategiu mapovania struktury objektov do databazy
public class Person {

    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private Integer age;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Phone> phones = new ArrayList<>();

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
    
    public void addPhone(Phone phone) {
        this.phones.add( phone );
        phone.setOwner( this );
    }
}
