package controller;

import bo.BoFactory;
import bo.Custom.AuserBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.AuserDto;
import dto.tm.AuserTm;
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

public class AdminUsersFormController {

    @FXML
    private TableView<AuserTm> adminTableU;

    @FXML
    private TableColumn<?, ?> colEmailA;

    @FXML
    private TableColumn<?, ?> colUserNameA;

    @FXML
    private TableColumn<?, ?> colOpasswordA;

    @FXML
    private TableColumn<?, ?> colOptA;

    @FXML
    private JFXTextField txtNameA;

    @FXML
    private JFXTextField txtEmailA;

    @FXML
    private JFXTextField txtPasswordA;

    AuserBo auserBo = BoFactory.getInstance().getBo(BoType.AUSER);

    public void initialize(){
        colEmailA.setCellValueFactory(new PropertyValueFactory<>("mail"));
        colUserNameA.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOpasswordA.setCellValueFactory(new PropertyValueFactory<>("password"));
        colOptA.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadAdminTable();
        adminTableU.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(AuserTm newValue) {
        if(newValue!=null){
            txtEmailA.setEditable(false);
            txtEmailA.setText(newValue.getMail());
            txtNameA.setText(newValue.getName());
            txtPasswordA.setText(newValue.getPassword());
        }
    }

    private void loadAdminTable() {
        ObservableList<AuserTm> list = FXCollections.observableArrayList();

        try {
            List<AuserDto> dtoList = auserBo.allAdmins();
            for (AuserDto dto :dtoList) {
                JFXButton btn = new JFXButton("Delete");
                AuserTm a = new AuserTm(
                        dto.getMail(),
                        dto.getName(),
                        dto.getPassword(),
                        btn
                );
                list.add(a);
                btn.setOnAction(actionEvent -> {
                    deleteAdmin(dto.getMail());
                });
            }
            adminTableU.setItems(list);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void deleteAdmin(String mail) {
        try {
            boolean isDeleted = auserBo.deleteAdmin(mail);
            if(isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Admin removed").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void backBtnOnAvtion(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) adminTableU.getScene().getWindow();

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

    public void registerBtnAOnAction(ActionEvent actionEvent) {
       AuserDto dto = new AuserDto(
               txtEmailA.getText(),
               txtNameA.getText(),
               txtPasswordA.getText()
       );
        try {
            boolean isSaved= auserBo.saveAdmin(dto);
            if(isSaved){
                new Alert(Alert.AlertType.INFORMATION," New admin saved").show();
                loadAdminTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!...").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void refreshBtnAOnAction(ActionEvent actionEvent) {
        adminTableU.refresh();
        clearFields();
        loadAdminTable();

    }

    private void clearFields() {
        txtEmailA.clear();
        txtNameA.clear();
        txtPasswordA.clear();
    }

    public void backBtnOnAction(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) adminTableU.getScene().getWindow();

            Parent root =  FXMLLoader.load(getClass().getResource("/view/UserMangementForm.fxml"));
            Scene scene = new Scene(root);
            if (scene != null) {

                scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                stage.setScene(scene);
                stage.setTitle(" User Management");
                stage.show();
            } else {
                System.err.println("Error: Scene is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
