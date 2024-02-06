package dao.custom.impl;

import dao.custom.PartDao;
import dao.util.HibernateUtil;
import entity.Part;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartDaoImpl implements PartDao {
    @Override
    public boolean save(Part entity) throws SQLException, ClassNotFoundException {
        String sql= "INSERT INTO part VALUES(?,?,?)";
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Part entity) throws SQLException, ClassNotFoundException {
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
        session.delete(session.find(Part.class,value));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Part> getAll() throws SQLException, ClassNotFoundException {
       List<Part> list = new ArrayList<>();
       Session session = HibernateUtil.getSession();
        Query query = session.createQuery("SELECT p FROM Part p");
        list=query.getResultList();
        session.close();
        return list;
    }
}
