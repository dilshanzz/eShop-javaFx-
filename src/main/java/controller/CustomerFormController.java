package controller;


import bo.BoFactory;
import bo.Custom.CustomerBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.custom.CustomerDao;
import dao.util.BoType;
import dto.CustomerDto;
import dto.tm.CustomerTm;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerFormController {
    @FXML
    private AnchorPane customerPane;

    public TableView<CustomerTm> customerTableC;
    @FXML
    private TableColumn<?, ?> colCustomIdC;

    @FXML
    private TableColumn<?, ?> colEmC;

    @FXML
    private TableColumn<?, ?> colNameC;

    @FXML
    private TableColumn<?, ?> colOptionC;

    @FXML
    private JFXTextField txtEmailC;

    @FXML
    private JFXTextField txtNameN;

    @FXML
    private JFXTextField txtCustIdC;

    CustomerBo customerBo = BoFactory.getInstance().getBo(BoType.CUSTOMER);

    public void initialize()  {
        colCustomIdC.setCellValueFactory(new PropertyValueFactory<>("id"));
        colEmC.setCellValueFactory(new PropertyValueFactory<>("mail"));
        colNameC.setCellValueFactory(new PropertyValueFactory<>("name"));
        colOptionC.setCellValueFactory((new PropertyValueFactory<>("btn")));
        loadCustomerTable();
        customerTableC.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->{
                    setData(newValue);
                });
    }

    private void setData(CustomerTm newValue) {
        if(newValue!=null){
            txtCustIdC.setEditable(false);
            txtCustIdC.setText(newValue.getId());
            txtEmailC.setText(newValue.getMail());
            txtNameN.setText(newValue.getName());

        }
    }

    private void loadCustomerTable()  {
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> dtoList = customerBo.allCustomers();
        for (CustomerDto dto: dtoList) {
            JFXButton btn = new JFXButton("Delete");

           CustomerTm customerTm = new CustomerTm(
                   dto.getContact(),
                   dto.getEmail(),
                   dto.getName(),
                   btn
           );

           btn.setOnAction( actionEvent -> {

                   deleteCustomer(customerTm.getId());

           });
           tmList.add(customerTm);
        }
        customerTableC.setItems(tmList);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(String id) {

        try {
           boolean isDeleted = customerBo.deleteCustomer(id);
            if(isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Customer Deleted").show();
                loadCustomerTable();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something went wrong!...").show();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void searchBtnCOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        List<CustomerDto> cList = customerBo.allCustomers();
        for(int i=0; i<cList.size(); i++){
            if(txtCustIdC.getText().equals(cList.get(i).getContact())){
                txtEmailC.setText(cList.get(i).getEmail());
                txtNameN.setText(cList.get(i).getName());
            }
        }
    }

    public void backBtnOnAvtion(ActionEvent actionevent) {

    }

    public void upBtnCOnAction(ActionEvent actionEvent) {
        CustomerDto dto = new CustomerDto(
                txtCustIdC.getText(),
                txtEmailC.getText(),
                txtNameN.getText()

        );
        try {
            boolean isUpdated= customerBo.updateCustomer(dto);
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Customer Detail Updated.").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!...").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveBtnCOnAction(ActionEvent actionEvent)  {
        CustomerDto Dto = new CustomerDto(
                txtCustIdC.getText(),
                txtEmailC.getText(),
                txtNameN.getText()
        );


        try {
            boolean isSaved=customerBo.save(Dto);
            if(isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Customer saved").show();
                loadCustomerTable();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void refreshBtnCOnAction(ActionEvent actionEvent) {
        loadCustomerTable();
        customerTableC.refresh();
        clearFields();
    }

    private void clearFields() {
        txtCustIdC.clear();
        txtEmailC.clear();
        txtNameN.clear();
        txtCustIdC.setEditable(true);
    }

    public String userControl(String user) {
        return user;
    }

    public void backBtnOnAction(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/LogInForm.fxml"));
        try {
            Parent root = loader.load();
            LogInFormController controller = loader.getController();
            String user = controller.getUserRole();
            if (user.equals("Admin")){
                Stage stage = (Stage) customerPane.getScene().getWindow();

                Parent root1 =  FXMLLoader.load(getClass().getResource("/view/AdmindashBoardForm.fxml"));
                Scene scene = new Scene(root);
                if (scene != null) {

                    scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                    stage.setScene(scene);
                    stage.setTitle("Admin Dashboard");
                    stage.show();
                } else {
                    System.err.println("Error: Scene is null");
                }
            }else{
                Stage stage = (Stage) customerPane.getScene().getWindow();

                Parent root2 =  FXMLLoader.load(getClass().getResource("/view/DefaultUserDashBoardForm.fxml"));
                Scene scene = new Scene(root);
                if (scene != null) {

                    scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                    stage.setScene(scene);
                    stage.setTitle("User Dashboard");
                    stage.show();
                } else {
                    System.err.println("Error: Scene is null");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}