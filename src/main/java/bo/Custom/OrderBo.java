package bo.Custom;

import bo.SuperBo;
import dto.OrderDto;
import entity.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrderBo extends SuperBo {



    Orders lastOrder();


    boolean save(OrderDto orderDto) throws SQLException, ClassNotFoundException;
}
