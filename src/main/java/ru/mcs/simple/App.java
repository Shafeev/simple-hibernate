package ru.mcs.simple;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.mcs.simple.model.Person;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person changePerson = new Person("Some Name", 60);
            session.persist(changePerson);

            session.getTransaction().commit();

            System.out.println(String.format("Id: %s", changePerson.getId()));

        } finally {
            sessionFactory.close();
        }
    }
}
