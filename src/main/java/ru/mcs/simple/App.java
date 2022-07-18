package ru.mcs.simple;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.mcs.simple.model.Item;
import ru.mcs.simple.model.Passport;
import ru.mcs.simple.model.Person;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person = new Person("Test person", 52);
            Passport passport = new Passport(person, 1212131);
            person.setPassport(passport);
            session.persist(person);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
