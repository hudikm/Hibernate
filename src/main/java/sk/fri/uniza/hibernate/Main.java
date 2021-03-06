/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.fri.uniza.hibernate;

import java.util.Date;
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
        Configuration conf = new Configuration();
        conf.configure();

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory buildSessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

        Session session = buildSessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student(new Date(), "Bod", 26);
        Lecturer lecturer = new Lecturer("KTK", "Martin", 27);
        Person person = new Person("Jozef",35);

        session.save(person);
        session.save(student);
        session.save(lecturer);
        session.getTransaction().commit();
        session.close();

        StandardServiceRegistryBuilder.destroy(registry);

    }

}
