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




    public String userControl() {
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        AuserDao auserDao = DaoFactory.getInstance().getDao(DaoType.AUSER);

        try {
            List<Auser>   list2 = auserDao.getAll();
            UserDao userDao = DaoFactory.getInstance().getDao(DaoType.USER);
            List<User> list3 = userDao.getAll();

            for (Auser auser:list2) {
                if(email.equals(auser.getMail()) && password.equals(auser.getPassword())){
                    UserRoleContext.setUserRole("Admin");
                    return "Admin";
                }
            }
            for (User user:list3) {
                if(email.equals(user.geteMail()) && password.equals(user.getPassword())){
                    UserRoleContext.setUserRole("User");
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
        String user = userControl();
        UserRoleContext.setUserRole(user);

        if(user .equals("Admin") ) {
            showAdminDashBoard();

        }else if(user.equals("User")){
            showUserDashBoard();
        }else{
            new Alert(Alert.AlertType.ERROR,"Invalid mail or password try again!...").show();
            clearFields();
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
        UserRoleContext.setEmail(txtEmail.getText());
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
        UserRoleContext.setEmail(txtEmail.getText());
        if(txtEmail.getText() ==null){
            new Alert(Alert.AlertType.ERROR,"Enter an email ").show();
            clearFields();
        }

        try {
            Stage stage = (Stage) logInForm.getScene().getWindow();

            Parent root =  FXMLLoader.load(getClass().getResource("/view/OTPForm.fxml"));
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

    private void clearFields() {
        txtEmail.clear();
        txtPassword.clear();
    }
}