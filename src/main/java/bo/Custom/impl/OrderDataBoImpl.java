package bo.Custom.impl;

import bo.Custom.OrderDataBo;
import dao.DaoFactory;
import dao.custom.OrderDataDao;
import dao.custom.UsedPartDao;
import dao.util.DaoType;
import dto.OrderDataDto;
import dto.UsedPartsDto;
import entity.OrderData;
import entity.UsedParts;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDataBoImpl implements OrderDataBo {
    OrderDataDao orderDataDao = DaoFactory.getInstance().getDao(DaoType.ORDERDATA);
    UsedPartDao usedPartDao = DaoFactory.getInstance().getDao(DaoType.USEDPARTS);
    @Override
    public List<OrderDataDto> lastOrder() {
        return null;
    }

    @Override
    public boolean save(OrderDataDto orderDataDto) throws SQLException, ClassNotFoundException {
        return orderDataDao.save(new OrderData(
                orderDataDto.getOrderId(),
                orderDataDto.getPartsPrice(),
                orderDataDto.getServiceCharge(),
                orderDataDto.getServiceCharge()

        ));
    }


}
