package dao.custom.impl;

import dao.custom.OrderDataDao;
import dao.util.HibernateUtil;
import entity.OrderData;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class OrderDataDaoImpl implements OrderDataDao {
    @Override
    public boolean save(OrderData entity) throws SQLException, ClassNotFoundException {
        try (Session session = HibernateUtil.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(OrderData entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<OrderData> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public boolean saveOrderData(List<OrderData> list) throws SQLException, ClassNotFoundException {
        try(Session session = HibernateUtil.getSession();)  {

            Transaction transaction = session.beginTransaction();

            for (OrderData data : list) {
                OrderData orderData = new OrderData(
                        data.getCode(),
                        data.getPartsPrice(),
                        data.getSc(),
                        data.getTotalAmount()
                );
                session.save(orderData);
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }
        return true;
    }
}

