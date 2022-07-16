package ru.mcs.simple;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.mcs.simple.model.Person;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction()

            List<Person> persons = session.createQuery("FROM Person", Person.class).getResultList();
            for (Person person : persons) {
                System.out.println(person.toString());
            }
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
