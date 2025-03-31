package org.example.DAO;

import org.example.DAO.entities.Owner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OwnerDAO implements DAO<Owner> {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public Owner get(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Owner.class, id);
        }
    }

    @Override
    public List<Owner> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Owner", Owner.class).list();
        }
    }

    @Override
    public void save(Owner owner) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(owner);
            tx.commit();
        }
    }

    @Override
    public void update(Owner owner) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(owner);
            tx.commit();
        }
    }

    @Override
    public void delete(Owner owner) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(owner);
            tx.commit();
        }
    }
}