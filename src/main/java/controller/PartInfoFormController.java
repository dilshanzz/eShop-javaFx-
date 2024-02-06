package controller;

import bo.BoFactory;
import bo.Custom.PartBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.PartDto;
import dto.tm.PartTm;
import entity.Part;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class PartInfoFormController {

    @FXML
    private TableView<PartTm> partTableP;;

    @FXML
    private TableColumn<?, ?> colPartId;

    @FXML
    private TableColumn<?, ?> colPartName;

    @FXML
    private TableColumn<?, ?> colPricePart;

    @FXML
    private TableColumn<?, ?> colOptionPart;

    @FXML
    private JFXTextField txtPartName;

    @FXML
    private JFXTextField txtPartPrice;

    @FXML
    private JFXTextField txtPartCode;

    PartBo partBo = BoFactory.getInstance().getBo(BoType.PART);

    public void initialize(){
        colPartId.setCellValueFactory(new PropertyValueFactory<>("code"));
        colPartName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPricePart.setCellValueFactory(new PropertyValueFactory<>("price"));
        colOptionPart.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadPartTable();
        partTableP.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });


    }

    private void setData(PartTm newValue) {
       if(newValue!=null){
           txtPartCode.setEditable(false);
           txtPartCode.setText(newValue.getCode());
           txtPartName.setText(newValue.getName());
           txtPartPrice.setText(String.valueOf(newValue.getPrice()));
       }
    }

    private void loadPartTable() {
        ObservableList<PartTm> list= FXCollections.observableArrayList();

        try {
            List<PartDto>  list1 = partBo.allParts();
            for (PartDto dto: list1) {
                JFXButton btn = new JFXButton("Delete");
                PartTm partTm = new PartTm(
                        dto.getCode(),
                        dto.getName(),
                        dto.getPrice(),
                        btn
                );
                btn.setOnAction(actionEvent -> {
                   deletePart(dto.getCode());
                });
                list.add(partTm);

            }
           partTableP.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void deletePart(String code) {
        try {
            boolean isDeleted = partBo.deletePart(code);
            if(isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Part Deleted").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong try again!...").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchBtnPOnAction(ActionEvent actionEvent) {
        try {
            List<PartDto> list = partBo.allParts();
            for(int i=0; i<list.size(); i++){
                if(txtPartCode.getText().equals(list.get(i))){
                    txtPartName.setText(list.get(i).getName());
                    txtPartPrice.setText(String.valueOf(list.get(i).getPrice()));
                }
                new Alert(Alert.AlertType.ERROR,"Part not exist").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void backBtnOnAvtion(ActionEvent actionEvent) throws IOException {
        LogInFormController log = new LogInFormController();
        String Mail=log.txtPassword.getText();
        if(Mail.equals("dilshanwijewardhana@")){
            Stage stage = (Stage)partTableP.getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AdminDashBoardForm.fxml"))));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            Stage stage = (Stage)partTableP.getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DefaultUserDashBoardForm.fxml"))));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public void upBtnCOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdated= partBo.update(new PartDto(
                    txtPartCode.getText(),
                    txtPartName.getText(),
                    Double.parseDouble(txtPartPrice.getText())
            ));
            if(isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Part updated").show();
                clearFields();
                loadPartTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!...").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveBtnCOnAction(ActionEvent actionEvent) {
        try {
            boolean isSaved= partBo.save(new PartDto(
                     txtPartCode.getText(),
                    txtPartName.getText(),
                    Double.parseDouble(txtPartPrice.getText())
             ));
            if(isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Part Saved").show();
                loadPartTable();
                clearFields();

            }else {
                new Alert(Alert.AlertType.ERROR,"Something went Wrong!...").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        txtPartCode.clear();
        txtPartName.clear();
        txtPartPrice.clear();
    }

    public void refreshBtnCOnAction(ActionEvent actionEvent) {
        loadPartTable();
        partTableP.refresh();
        clearFields();

    }
}
