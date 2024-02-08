package bo.Custom;

import bo.SuperBo;
import dto.OrderDataDto;

import java.util.List;

public interface OrderDataBo extends SuperBo {
    List<OrderDataDto> lastOrder();


}
