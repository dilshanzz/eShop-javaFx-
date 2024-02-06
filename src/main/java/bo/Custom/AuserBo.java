package bo.Custom;

import bo.SuperBo;
import dto.AuserDto;

import java.sql.SQLException;
import java.util.List;

public interface AuserBo extends SuperBo {
    List<AuserDto> allAdmins() throws SQLException, ClassNotFoundException;

    boolean deleteAdmin(String mail) throws SQLException, ClassNotFoundException;

    boolean saveAdmin(AuserDto dto) throws SQLException, ClassNotFoundException;
}
