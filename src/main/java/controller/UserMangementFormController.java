package controller;

import bo.BoFactory;
import bo.Custom.UserBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.UserDto;
import dto.tm.UserTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class UserMangementFormController {

    public TableColumn colEmailu;
    @FXML
    private TableView<UserTm> userTableU;

    @FXML
    private TableColumn<?, ?> colUserNameU;

    @FXML
    private TableColumn<?, ?> colPasswordU;

    @FXML
    private TableColumn<?, ?> colOptU1;

    @FXML
    private JFXTextField txtNameU;

    @FXML
    private JFXTextField txtEmailU;

    @FXML
    private JFXTextField txtPasswordU;

    private UserBo userBo = BoFactory.getInstance().getBo(BoType.USER);

    public void initialize(){
        colUserNameU.setCellValueFactory(new PropertyValueFactory<>("name"));
         colEmailu.setCellValueFactory(new PropertyValueFactory<>("mail"));
         colPasswordU.setCellValueFactory(new PropertyValueFactory<>("password"));
        colOptU1.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadUserTable();

        userTableU.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
           setData(newValue);
        });
    }

    private void setData(UserTm newValue) {
        if(newValue!=null){
            txtEmailU.setEditable(false);
            txtEmailU.setText(newValue.getMail());
            txtNameU.setText(newValue.getName());
            txtPasswordU.setText(newValue.getPassword());
        }
    }

    private void loadUserTable() {
        ObservableList<UserTm> tmList = FXCollections.observableArrayList();
        try{
            List<UserDto> dtoList = userBo.allUsers();

            for (UserDto dto : dtoList) {
                JFXButton button = new JFXButton("Delete");

                UserTm userTm = new UserTm(
                        dto.getUserName(),
                        dto.getUserEmail(),
                        dto.getPassword(),
                        button
                );
                button.setOnAction(actionEvent -> {
                    try {

                        deleteUser(userTm.getMail());
                    } catch (SQLException e) {
                       e.printStackTrace(); ;
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
                tmList.add(userTm);
            }
            userTableU.setItems(tmList);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void clearFields(){
        userTableU.refresh();
        txtEmailU.clear();
        txtNameU.clear();
        txtPasswordU.clear();
        txtEmailU.setEditable(true);
    }

    private void deleteUser(String mail) throws SQLException, ClassNotFoundException {
        boolean isDeleted = userBo.deleteUser(mail);
        if(isDeleted){
            new Alert(Alert.AlertType.INFORMATION,"User Deleted").show();
            loadUserTable();
        }else {
            new Alert(Alert.AlertType.ERROR,"Something Went Wrong!");
        }
    }

    public void registerBtnUOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

           UserDto dto = new UserDto(
                   txtNameU.getText(),
                   txtEmailU.getText(),
                   txtPasswordU.getText()
           );
           boolean isRegistered = userBo.saveUser(dto);
           if(isRegistered){
              new Alert(Alert.AlertType.INFORMATION,"User Registration Complete");
               clearFields();
               loadUserTable();

           }else{
               new Alert(Alert.AlertType.ERROR,"Something Went Wrong... Try agin!..");
           }
    }

    public void refreshBtnUOnAction(ActionEvent actionEvent) {
        loadUserTable();
        userTableU.refresh();
        clearFields();
    }


    public void adminBtnOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) userTableU.getScene().getWindow();

            Parent root =  FXMLLoader.load(getClass().getResource("/view/AdminUsersForm.fxml"));
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

    public void backButtonOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) userTableU.getScene().getWindow();

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

    public void backBtnOnAvtion(MouseEvent mouseEvent) {
    }
}
