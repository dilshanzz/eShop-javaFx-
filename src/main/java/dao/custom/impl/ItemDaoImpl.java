package dao.custom.impl;

import dao.custom.ItemDao;
import dao.util.HibernateUtil;
import entity.Item;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO item VALUES (?,?,?)";
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Item entity) throws SQLException, ClassNotFoundException {
       Session session = HibernateUtil.getSession();
       Transaction transaction = session.beginTransaction();
       session.update(entity);
       transaction.commit();
       session.close();
       return true;

    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Item.class,value));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Item> getAll() throws SQLException, ClassNotFoundException {
        List<Item> list = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("SELECT i FROM Item i");
        list = query.getResultList();
        session.close();
        return list;
    }
}
