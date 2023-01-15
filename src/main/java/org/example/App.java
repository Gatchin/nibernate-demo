package org.example;

import org.example.models.Item;
import org.example.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Item ball = new Item(null, "ball");
            Item phone = new Item(null, "phone");
            Item plate = new Item(null, "plate");
            session.save(ball);
            session.save(phone);
            session.save(plate);
            Person p1 = new Person("Tom", 30);
            Person p2 = new Person("Jack", 43);
            ball.setOwner(p1);
            p1.addItem(ball);
            session.save(p1);
            session.save(ball);


            session.getTransaction().commit();
        }

    }
}
