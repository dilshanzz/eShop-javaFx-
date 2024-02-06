package bo.Custom;

import bo.SuperBo;
import dto.OrderDto;
import dto.PartDto;

import java.sql.SQLException;
import java.util.List;

public interface PartBo extends SuperBo {
    List<PartDto> allParts() throws SQLException, ClassNotFoundException;

    boolean save(PartDto partDto) throws SQLException, ClassNotFoundException;

    boolean update(PartDto partDto) throws SQLException, ClassNotFoundException;

    boolean deletePart(String code) throws SQLException, ClassNotFoundException;

    boolean saveOrderPart(OrderDto orderDto);
}
