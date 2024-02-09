package controller;

import com.jfoenix.controls.JFXTextField;
import dao.DaoFactory;
import dao.custom.AuserDao;
import dao.custom.UserDao;
import dao.util.DaoType;
import entity.Auser;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;



public class ResetPasswordFormController {
    public void  initialize(){

    }
    @FXML
    private JFXTextField txtPasswordRp1;

    @FXML
    private JFXTextField txtPasswordRp2;



    UserDao userDao = DaoFactory.getInstance().getDao(DaoType.USER);
    AuserDao auserDao = DaoFactory.getInstance().getDao(DaoType.AUSER);

    public boolean isValid(String np){

       if(np .length()> 8 && containsDigits(np) && containsSymbols(np) &&
                containsLetters(np))
       {
        return true;
       }

        return false;
    }

    private boolean containsLetters(String np) {
        return np.matches(".*[a-zA-Z].*");
    }

    private boolean containsSymbols(String np) {
        return np.matches(".*[!@#$%^&*()-_=+{};:,<.>?/\\\\[\\\\]\"].*");
    }

    private boolean containsDigits(String np) {
        return np.matches(".*\\d.*");
    }

    public void confirmBtnOnAction(ActionEvent actionEvent) {
        String email = UserRoleContext.getEmail();
        String np = txtPasswordRp1.getText();
        String np2 = txtPasswordRp1.getText();

       if(isValid(np) && np.equals(np2)){
           try {
               List<User> list1 = userDao.getAll();
               List<Auser> list2 = auserDao.getAll();

               for (User u:list1) {
                   if(email.equals(u.geteMail())){
                       userDao.updatePassword(email,np2);
                   }
               }
               for (Auser a: list2) {
                   if(email.equals(a.getMail())){
                       auserDao.updatePassword(email,np2);
                   }
               }

               Stage stage = (Stage) txtPasswordRp2.getScene().getWindow();

               Parent root =  FXMLLoader.load(getClass().getResource("/view/LogInForm.fxml"));
               Scene scene = new Scene(root);
               if (scene != null) {

                   scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                   stage.setScene(scene);
                   stage.setTitle("Admin Dashboard");
                   stage.show();
               } else {
                   System.err.println("Error: Scene is null");
               }

           } catch (SQLException e) {
               throw new RuntimeException(e);
           } catch (ClassNotFoundException e) {
               throw new RuntimeException(e);
           } catch (IOException e) {
               throw new RuntimeException(e);
           }
       }else if(!txtPasswordRp1.getText().equals(txtPasswordRp2.getText())){
           new Alert(Alert.AlertType.ERROR,"Password dosent match!...").show();
       }else{
           new Alert(Alert.AlertType.ERROR,"Password not valid!...").show();
       }
       }
}
