package dao.custom;

import dao.CrudDao;
import dao.SuperDao;
import entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao extends CrudDao<User> {



    List<User> getAll() throws SQLException, ClassNotFoundException;
}
