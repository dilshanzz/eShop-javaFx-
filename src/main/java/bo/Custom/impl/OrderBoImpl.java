package bo.Custom.impl;

import bo.Custom.OrderBo;
import dao.DaoFactory;
import dao.custom.OrderDao;
import dao.util.DaoType;
import dto.OrderDataDto;
import dto.OrderDto;
import dto.PartDto;
import dto.tm.OrderTm;
import entity.OrderData;
import entity.Orders;
import org.hibernate.criterion.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderBoImpl implements OrderBo {
    OrderDao orderDao = DaoFactory.getInstance().getDao(DaoType.ORDER);


    @Override
    public Orders lastOrder() {
        return orderDao.lastOrder();
    }

    @Override
    public boolean save(OrderDto orderDto) throws SQLException, ClassNotFoundException {

        return orderDao.save(new Orders(
                orderDto.getContact(),
                orderDto.getCname(),
                orderDto.getEmail(),
                orderDto.getItemName(),
                orderDto.getDescription(),
                orderDto.getCategory(),
                orderDto.getOrderId(),
                orderDto.getDate(),
                orderDto.getStatus()

        ));
    }

    @Override
    public List<OrderDto> allOrders() throws SQLException, ClassNotFoundException {
        List<Orders> list = orderDao.getAll();
        List<OrderDto> list1 = new ArrayList<>();
        for (Orders orders: list) {
            list1.add(new OrderDto(

                    orders.getContact(),
                    orders.getOrderId(),
                    orders.getItemName(),
                    orders.getDescription(),
                    orders.getCategory(),
                    orders.getDate(),
                    orders.getStatus(),
                    orders.getCname(),
                    orders.getEmail()


            ));
            System.out.println(orders.getOrderId());
        }
        return list1;
    }

    @Override
    public boolean delete(String orderId) throws SQLException, ClassNotFoundException {
        return orderDao.delete(orderId);
    }


}
