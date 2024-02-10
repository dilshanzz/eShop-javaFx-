package bo.Custom;

import bo.SuperBo;
import dto.UsedPartsDto;

import java.sql.SQLException;

public interface UsedPartsBo extends SuperBo {
     boolean save(UsedPartsDto dto) throws SQLException;
}
