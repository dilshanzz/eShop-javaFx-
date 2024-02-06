package dao.custom.impl;

import dao.custom.UserDao;
import dao.util.HibernateUtil;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public boolean save(User entity) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO user VALUES(?,?,?)";

        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        Session session=HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(session.find(User.class,value));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        List<User> list = new ArrayList<>();
        Session session = HibernateUtil.getSession();
        Query query = session.createQuery("SELECt u FROM User u");
        list = query.getResultList();
        session.close();;
        return list;
    }

}
