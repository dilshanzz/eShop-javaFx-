package dao.custom.impl;

import dao.custom.AuserDao;
import dao.util.HibernateUtil;
import entity.Auser;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuserDaoImpl implements AuserDao {
    @Override
    public boolean save(Auser entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO auser VALUES(?,?,?)";
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Auser entity) throws SQLException, ClassNotFoundException {

        return true;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(Auser.class,value));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Auser> getAll() throws SQLException, ClassNotFoundException {
        List<Auser> list = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("SELECT user FROM Auser user");
        list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public void updatePassword(String email, String np) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE Auser SET password = :np WHERE mail = :email");
        query.setParameter("np", np);
        query.setParameter("email", email);

        query.executeUpdate(); // Execute the update query

        transaction.commit();
        session.close();

    }
}
