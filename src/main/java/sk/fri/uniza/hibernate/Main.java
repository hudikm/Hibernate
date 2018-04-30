/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.hibernate;

import java.util.Date;
import java.util.List;
import jdk.nashorn.internal.objects.NativeArray;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.MetadataSource;

/**
 *
 * @author hudik1
 */
public class Main {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory buildSessionFactory = new MetadataSources(registry).addResource("hibernate.cfg.xml").buildMetadata().buildSessionFactory();

        Session session = buildSessionFactory.openSession();
        session.beginTransaction();

        //Create Students
        Student student1 = new Student(new Date(), "Bod", 24);
        Student student2 = new Student(new Date(), "Joe", 25);
        Student student3 = new Student(new Date(), "Milan", 26);
        Student student4 = new Student(new Date(), "Juraj", 27);

        //Create Lecturers
        Lecturer lecturer1 = new Lecturer("KTK", "Martin", 29);
        Lecturer lecturer2 = new Lecturer("KTK", "Peter", 32);

        Person person = new Person("Jozef", 35);

        // Create student classes
        StudentClass studentClass1 = new StudentClass("Trieda 1");
        StudentClass studentClass2 = new StudentClass("Trieda 2");

        // Add phone numbers
        person.addPhone(new Phone("123456789"));
        student4.addPhone(new Phone("76853258"));
        student3.addPhone(new Phone("889524874"));

        studentClass1.addStudent(student1);
        studentClass1.addStudent(student2);

        studentClass2.addStudent(student3);
        studentClass2.addStudent(student4);

        lecturer1.addClass(studentClass1);
        lecturer1.addClass(studentClass2);
        lecturer2.addClass(studentClass1);

        session.save(person);
        session.save(student1);
        session.save(student2);
        session.save(student3);
        session.save(student4);

        session.save(lecturer1);
        session.save(lecturer2);

        //session.flush();
        session.save(studentClass1);
        session.save(studentClass2);
        session.getTransaction().commit();
        session.close();

        // Create queries
        session = buildSessionFactory.openSession();
        List<Student> studentList = session.createQuery("FROM Student AS st where st.age > :age").setParameter("age", 25).getResultList();

        for (Student student : studentList) {
            System.out.println(student.getFirstName() + " Age " + student.getAge());
        }

        List<Student> studentList2 = session.createQuery("SELECT st FROM Student AS st join st.phones AS ph where ph.number = :phoneNumber", Student.class).setParameter("phoneNumber", "76853258").getResultList();

        for (Student student : studentList2) {
            System.out.println(student.getFirstName());
            
        }
        session.close();

        StandardServiceRegistryBuilder.destroy(registry);

    }

    public Main() {
    }

}
