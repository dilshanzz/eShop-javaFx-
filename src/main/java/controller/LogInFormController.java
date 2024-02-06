package controller;

import com.jfoenix.controls.JFXTextField;
import dao.DaoFactory;
import dao.custom.AuserDao;
import dao.custom.UserDao;
import dao.util.DaoType;
import dto.AuserDto;
import dto.UserDto;
import entity.Auser;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LogInFormController {

    UserRoleContext userRoleContext = new UserRoleContext();
    private Parent root1;
    public AnchorPane logInForm;
    public JFXTextField txtEmail;
    public JFXTextField txtPassword;

    public  String userRole ;



    public String getUserRole(){
        return userRole;
    }
    public void setUserRole(String userRole){
        this.userRole=userRole;

    }

    public String userControl() {
        String email = txtPassword.getText();
        String password = txtEmail.getText();

        AuserDao auserDao = DaoFactory.getInstance().getDao(DaoType.AUSER);

        try {
            List<Auser>   list2 = auserDao.getAll();
            UserDao userDao = DaoFactory.getInstance().getDao(DaoType.USER);
            List<User> list3 = userDao.getAll();

            for (Auser auser:list2) {
                if(email.equals(auser.getMail()) && password.equals(auser.getPassword())){
                   setUserRole("Admin");
                    return "Admin";
                }
            }
            for (User user:list3) {
                if(email.equals(user.geteMail()) && password.equals(user.getPassword())){
                    setUserRole("User");
                    return "User";
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "None";
    }

    public void logInBtnOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
       ShareData shareData = new ShareData();
       shareData.user(txtPassword.getText());
        String user = userControl();

        if(user .equals("Admin") ) {
            showAdminDashBoard();
        }else if(user.equals("User")){
            showUserDashBoard();
        }else{
            new Alert(Alert.AlertType.ERROR,"Invalid mail or password try again!...").show();
        }
    }
    public void showUserDashBoard() {

        try {
            Stage stage = (Stage) logInForm.getScene().getWindow();

            Parent root =  FXMLLoader.load(getClass().getResource("/view/DefaultUserDashBoardForm.fxml"));
            Scene scene = new Scene(root);
            if (scene != null) {

                scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                stage.setScene(scene);
                stage.setTitle("User Dashboard");
                stage.show();
            } else {
                System.err.println("Error: Scene is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAdminDashBoard(){
        try {
            Stage stage = (Stage) logInForm.getScene().getWindow();

            Parent root =  FXMLLoader.load(getClass().getResource("/view/AdmindashBoardForm.fxml"));
            Scene scene = new Scene(root);
            if (scene != null) {

                scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                stage.setScene(scene);
                stage.setTitle("Admin Dashboard");
                stage.show();
            } else {
                System.err.println("Error: Scene is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void forgetBtnOnAction(ActionEvent actionEvent) {

    }
}