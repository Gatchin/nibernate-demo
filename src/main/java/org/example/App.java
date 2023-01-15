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

            // Person p1 = new Person("Tom", 30);
            Person p2 = new Person("Jack", 43);
            session.save(p2);
            Item ball = session.get(Item.class, 7);
            ball.setOwner(p2);
            p2.addItem(ball);


            session.getTransaction().commit();
        }

    }
}
