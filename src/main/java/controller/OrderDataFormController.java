package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class OrderDataFormController {

    @FXML
    private TableView<?> odrTableO;

    @FXML
    private TableColumn<?, ?> colOdrIdO;

    @FXML
    private TableColumn<?, ?> colItemNameO;

    @FXML
    private TableColumn<?, ?> colItemDescriptionO;

    @FXML
    private TableColumn<?, ?> colStatus2;

    @FXML
    private TableColumn<?, ?> colDateO;

    @FXML
    private TableColumn<?, ?> colStatusO;

    @FXML
    private TableColumn<?, ?> colCustomercontactO;

    @FXML
    private TableColumn<?, ?> colCusName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colOptionO11;

    @FXML
    private JFXTextField txtOdrIdO;

    @FXML
    private JFXTextField txtItemNameO;

    @FXML
    private JFXTextField txtDescripO;

    @FXML
    private JFXTextField txtDateO;

    @FXML
    private Label lblPartAmountO;

    @FXML
    private Label lblTotalAmountO;

    @FXML
    private JFXComboBox<?> combPartCodeO;

    @FXML
    private JFXComboBox<?> combStatusO;

    @FXML
    private JFXTextField txtCatO;

    @FXML
    private JFXTextField txtScO;


    public void searchBtnOOnAction(ActionEvent actionEvent) {
    }

    public void backBtnOnAction(ActionEvent actionEvent) {
    }

    public void refreshBtnOOnAction(ActionEvent actionEvent) {
    }

    public void upBtnCOnAction(ActionEvent actionEvent) {
    }

    public void saveBtnOnAction(ActionEvent actionEvent) {
    }
}
