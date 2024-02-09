package bo.Custom;

import bo.SuperBo;
import dto.OrderDataDto;
import dto.UsedPartsDto;

import java.sql.SQLException;
import java.util.List;

public interface OrderDataBo extends SuperBo {
    List<OrderDataDto> lastOrder();



    boolean save(OrderDataDto orderDataDto) throws SQLException, ClassNotFoundException;
}
