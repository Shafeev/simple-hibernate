package ru.mcs.simple;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.mcs.simple.model.movie.Actor;
import ru.mcs.simple.model.movie.Movie;
import ru.mcs.simple.model.person.Item;
import ru.mcs.simple.model.person.Passport;
import ru.mcs.simple.model.person.Person;
import ru.mcs.simple.model.virtual.VirtualData;
import ru.mcs.simple.model.virtual.VirtualField;
import ru.mcs.simple.model.virtual.VirtualObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        movieExample();
//        personExample();
//        virtualExample();
    }

    private static void movieExample() {
        Configuration configuration = new Configuration().addAnnotatedClass(Movie.class)
                .addAnnotatedClass(Actor.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        try (sessionFactory) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Movie movie = session.get(Movie.class, 1);
            System.out.println(movie.getActors());
            Actor actor= session.get(Actor.class, 1);
            System.out.println(actor.getName());

            session.getTransaction().commit();
        }
    }


    private static void personExample() {
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

    private static void virtualExample() {
        Configuration configuration = new Configuration().addAnnotatedClass(VirtualObject.class)
                .addAnnotatedClass(VirtualField.class)
                .addAnnotatedClass(VirtualData.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            VirtualObject vObject = new VirtualObject("CustomObject");
            int fieldNum = 0;
            VirtualField vField = new VirtualField("Name1", "String", false, fieldNum++, vObject);
            vObject.setVirtualFieldList(new ArrayList<>(Collections.singleton(vField)));

            VirtualData vData1 = new VirtualData(vObject, "CustomObject", "value1", "123", "false", null, null, null, null, null, null, null);
            vObject.setVirtualDataList(new ArrayList<>(Collections.singleton(vData1)));

            session.persist(vObject);
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
