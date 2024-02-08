package dao.custom;

import dao.CrudDao;
import entity.OrderData;

import java.sql.SQLException;
import java.util.List;

public interface OrderDataDao extends CrudDao<OrderData> {
    boolean saveOrderData(List<OrderData> list) throws SQLException, ClassNotFoundException;
}
