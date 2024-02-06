package bo.Custom;

import bo.SuperBo;
import dto.OrderDto;
import dto.UsedPartsDto;
import entity.Orders;
import entity.UsedParts;

import java.sql.SQLException;
import java.util.List;

public interface OrderBo extends SuperBo {
    Orders lastOrder();




    boolean save(OrderDto orderDto, List<UsedPartsDto>list) throws SQLException, ClassNotFoundException;

    // You can add other methods as needed
}
