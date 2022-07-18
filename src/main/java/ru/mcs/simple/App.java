package ru.mcs.simple;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.mcs.simple.model.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class)

                ;

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            VirtualObject vObject = new VirtualObject("Account");
//            VirtualField vField = new VirtualField()
            Person person = session.get(Person.class, 2);
            System.out.println(person);

            Item newItem = new Item("Item from H1", person);
            Item newItem2 = new Item("Item from H1", person);

            session.persist(newItem);
            session.persist(newItem2);
//            List<Item> items = person.getItems();
//            System.out.println(items);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
