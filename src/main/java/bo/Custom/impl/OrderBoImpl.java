package bo.Custom.impl;

import bo.Custom.OrderBo;
import dao.DaoFactory;
import dao.custom.OrderDao;
import dao.util.DaoType;
import dto.OrderDataDto;
import dto.OrderDto;
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
                orderDto.getStatus(),
                convertToOrderDataList(orderDto.getList())

        ));
    }
    private List<OrderData> convertToOrderDataList(List<OrderDataDto> dataList) {
        List<OrderData> list = new ArrayList<>();
        for (OrderDataDto  o: dataList) {
            list.add( new OrderData(
                    o.getCode(),
                    o.getPartsPrice(),
                    o.getSc(),
                    o.getTotalAmount()
            ));


        }
        return list;
    }


}
