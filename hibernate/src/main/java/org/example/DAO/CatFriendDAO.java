package org.example.DAO;

import org.example.DAO.entities.CatFriend;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CatFriendDAO implements DAO<CatFriend> {
    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @Override
    public CatFriend get(Integer id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(CatFriend.class, id);
        }
    }

    @Override
    public List<CatFriend> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from CatFriend", CatFriend.class).list();
        }
    }

    @Override
    public void save(CatFriend catFriend) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(catFriend);
            tx.commit();
        }
    }

    @Override
    public void update(CatFriend catFriend) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(catFriend);
            tx.commit();
        }
    }

    @Override
    public void delete(CatFriend catFriend) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(catFriend);
            tx.commit();
        }
    }
}