package org.example.DAO;


import org.example.DAO.entities.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CatDAO implements DAO<Cat> {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public Cat get(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Cat.class, id);
        }
    }

    @Override
    public List<Cat> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Cat", Cat.class).list();
        }
    }

    @Override
    public void save(Cat cat) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(cat);
            tx.commit();
        }
    }

    @Override
    public void update(Cat cat) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(cat);
            tx.commit();
        }
    }

    @Override
    public void delete(Cat cat) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(cat);
            tx.commit();
        }
    }
}