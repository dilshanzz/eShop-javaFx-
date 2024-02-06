package controller;

import dao.DaoFactory;
import dao.custom.AuserDao;
import dao.custom.UserDao;
import dao.util.DaoType;
import entity.Auser;
import entity.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShareData {

    public String userole;


    public String user(String user){


        AuserDao auserDao = DaoFactory.getInstance().getDao(DaoType.AUSER);



            try {
                List<Auser>  list2 = auserDao.getAll();
                for (Auser auser:list2) {
                    if(user.equals(auser.getMail())){
                        return "Admin";
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

}
