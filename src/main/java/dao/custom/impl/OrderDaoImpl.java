//package dao.custom.impl;
//
//import dao.DaoFactory;
//import dao.custom.OrderDao;
////import dao.custom.OrderDataDao;
//import dao.util.DaoType;
//import dao.util.HibernateUtil;
//import entity.Orders;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//import org.hibernate.query.Query;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderDaoImpl implements OrderDao {
//    OrderDataDao orderDataDao = DaoFactory.getInstance().getDao(DaoType.ORDERDATA);
//    @Override
//    public boolean save(Orders entity) throws SQLException, ClassNotFoundException {
//        Session session = HibernateUtil.getSession();
//        Transaction transaction = session.beginTransaction();
//        session.save(entity);
//        transaction.commit();
//        session.close();
//        return true;
//
//    }
//
//    @Override
//    public boolean update(Orders entity) throws SQLException, ClassNotFoundException {
//
//        return false;
//    }
//
//    @Override
//    public boolean delete(String value) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public List<Orders> getAll() throws SQLException, ClassNotFoundException {
//        List<Orders> list2 = new ArrayList<>();
//        Session session = HibernateUtil.getSession();
//        Query query = session.createQuery("SELECT o FROM Orders o");
//        list2= query.getResultList();
//        session.close();
//        return list2;
//
//    }
//
//    @Override
//    public Orders lastOrder() {
//        try (Session session = HibernateUtil.getSession()) {
//            Query<Orders> query = session.createQuery("SELECT o FROM Orders o WHERE o.orderId = (SELECT MAX(o2.orderId) FROM Orders o2)", Orders.class);;
//            return query.uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//
//
//}
