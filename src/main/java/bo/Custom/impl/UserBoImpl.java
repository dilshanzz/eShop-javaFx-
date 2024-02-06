package bo.Custom.impl;

import bo.Custom.UserBo;
import dao.DaoFactory;
import dao.custom.UserDao;
import dao.util.DaoType;
import dto.UserDto;
import entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBoImpl implements UserBo {

    private UserDao userDao = DaoFactory.getInstance().getDao(DaoType.USER);

    @Override
    public List<UserDto> allUsers() throws SQLException, ClassNotFoundException {
        List<User> userList = userDao.getAll();
        List<UserDto> list = new ArrayList<>();

        for (User user:userList) {
            list.add(new UserDto(

                    user.geteMail(),
                    user.getUserName(),
                    user.getPassword()
            ));

        }
        return list;
    }

    @Override
    public boolean saveUser(UserDto dto) throws SQLException, ClassNotFoundException {
        return userDao.save(new User(
                dto.getUserName(),
                dto.getUserEmail(),
                dto.getPassword()
        ));
    }

    @Override
    public boolean deleteUser(String mail) throws SQLException, ClassNotFoundException {
        return userDao.delete(mail);
    }
}
