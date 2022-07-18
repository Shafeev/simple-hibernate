package ru.mcs.simple;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.mcs.simple.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(VirtualObject.class)
                .addAnnotatedClass(VirtualField.class)
                .addAnnotatedClass(VirtualData.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            VirtualObject vObject = new VirtualObject("CustomObject");
//            session.persist(vObject);

            int fieldNum = 0;
            VirtualField vField = new VirtualField("Name1", "String", false, fieldNum++, vObject);
            vObject.setVirtualFieldList(new ArrayList<>(Collections.singleton(vField)));
//            VirtualField vField3 = new VirtualField("Name3", "Checkbox", false, fieldNum++, vObject);
//            session.persist(vField2);
//            session.persist(vField3);

            VirtualData vData1 = new VirtualData(vObject, "CustomObject", "value1", "123", "false", null, null, null, null, null, null, null);
            vObject.setVirtualDataList(new ArrayList<>(Collections.singleton(vData1)));

            session.persist(vObject);
//            VirtualData vData2 = new VirtualData(vObject, "Account1", "value2", "456", "false", null, null, null, null, null, null, null);
//            VirtualData vData3 = new VirtualData(vObject, "Account1", "value3", "789", "true", null, null, null, null, null, null, null);
//            VirtualData vData4 = new VirtualData(vObject, "Account1", "value4", "012", "false", null, null, null, null, null, null, null);
//            session.persist(vData1);
//            session.persist(vData2);
//            session.persist(vData3);
//            session.persist(vData4);


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
