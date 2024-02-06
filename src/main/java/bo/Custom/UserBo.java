package bo.Custom;

import bo.SuperBo;
import dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBo extends SuperBo {

    List<UserDto> allUsers() throws SQLException, ClassNotFoundException;

    boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException;

    boolean deleteUser(String mail) throws SQLException, ClassNotFoundException;
}
