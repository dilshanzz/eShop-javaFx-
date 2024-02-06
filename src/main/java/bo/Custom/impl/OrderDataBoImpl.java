//package bo.Custom.impl;
//
//import bo.Custom.OrderDataBo;
//import dao.DaoFactory;
//import dao.custom.OrderDataDao;
//import dao.util.DaoType;
//import dto.OrderDataDto;
//import entity.OrderData;
//import entity.Orders;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class OrderDataBoImpl implements OrderDataBo {
//    OrderDataDao orderDataDao = DaoFactory.getInstance().getDao(DaoType.ORDERDATA);
//    @Override
//    public List<OrderDataDto> lastOrder() {
//        return null;
//    }
//
//    @Override
//    public boolean save(OrderDataDto orderDataDto, Orders orders) throws SQLException, ClassNotFoundException {
//        return orderDataDao.save(new OrderData(
//                orderDataDto.getCode(),
//                orderDataDto.getPartsPrice(),
//                orderDataDto.getSc(),
//                orderDataDto.getTotalAmount(),
//                orders
//        ));
//    }
//}
