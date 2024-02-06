package controller;

import bo.BoFactory;
import bo.Custom.CustomerBo;
import bo.Custom.ItemBo;
import bo.Custom.OrderBo;
//import bo.Custom.OrderDataBo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.*;
//import entity.OrderData;
import entity.Orders;
import entity.UsedParts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PlaceOrderFormController {

    @FXML
    private JFXTextField txtCatPo;

    @FXML
    private JFXComboBox txtItemNameCb;

    @FXML
    private JFXTextField txtOrderIDPO;

    @FXML
    private JFXTextField txtCustomerNamePO;

    @FXML
    private JFXTextField txtEmailPO;

    @FXML
    private JFXTextField txtCustomerIdPO;

    @FXML
    private Label labelDatePO;

    @FXML
    private JFXTextField txtDescriptionPO;

    ItemBo itemBo = BoFactory.getInstance().getBo(BoType.ITEM);
    OrderBo orderBo = BoFactory.getInstance().getBo(BoType.ORDER);
//    OrderDataBo orderDataB0 = BoFactory.getInstance().getBo(BoType.ORDERDATA);

    CustomerBo customerBo = BoFactory.getInstance().getBo(BoType.CUSTOMER);
   // OrderData orderData = new OrderData();

    public  void  initialize(){
        generateId();
        setItemNames();
        addingListners();

    }
    private void addingListners() {
        txtItemNameCb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            updateFielsd();
        });
        txtCatPo.textProperty().addListener((observable, oldValue, newValue) -> {
            updateFielsd();
        });
    }

    private void updateFielsd() {
        try {

            List<ItemDto> list = itemBo.allItems();
            String name = txtItemNameCb.getValue().toString();
            if (name != null && !name.isEmpty()) {
                for (ItemDto item : list) {
                    if (item.getName().equals(name)) {
                        txtCatPo.setText(item.getCategory());
                        return;
                    }

                }
            } else if (txtItemNameCb.getValue().toString().equals("none")) {
                txtCatPo.setText("None");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateId(){
        Orders dto = orderBo.lastOrder();
        if(dto!=null) {
            String id = dto.getOrderId();
            int num = Integer.parseInt(id.split("#")[1]);
            num++;
            txtOrderIDPO.setText("Order#"+num);
        }else{
            txtOrderIDPO.setText("Order#1");
        }
    }

    public void setItemNames() {
        ObservableList<String> list = FXCollections.observableArrayList();

        try {
            List<ItemDto> list2 = itemBo.allItems();

            for (ItemDto item : list2) {
                list.add(item.getName());
            }
            txtItemNameCb.setItems(list);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void placeBtnOnAction(ActionEvent actionEvent) {
        if (txtCustomerIdPO.getText() != null && !txtCustomerIdPO.getText().isEmpty() &&
                txtCustomerNamePO.getText() != null && !txtCustomerNamePO.getText().isEmpty() &&
                txtEmailPO.getText() != null && !txtEmailPO.getText().isEmpty() &&
                txtItemNameCb != null && !txtItemNameCb.getValue().toString().equals("none") && !txtItemNameCb.getValue().toString().isEmpty()) {
            addCustomer();
            try {
                List<UsedPartsDto> list = new ArrayList<>();
                boolean isSavad = orderBo.save(new OrderDto(
                        txtCustomerIdPO.getText(),
                        txtCustomerNamePO.getText(),
                        txtEmailPO.getText(),
                        txtItemNameCb.getValue().toString(),
                        txtDescriptionPO.getText(),
                        txtCatPo.getText(),
                        txtOrderIDPO.getText(),
                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd")),
                        "Pending",
                        0.0,
                        0.0,
                        0.0
                ),list);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        } else {
            new Alert(Alert.AlertType.ERROR, "Fields cannot be empty!...").show();
        }


    }

    private void savePartsData(Orders savedOrder) {

    }


    private void addCustomer() {

        try {
            List<CustomerDto>   list1 = customerBo.allCustomers();
            boolean isExist = false;

        for (CustomerDto dto: list1) {
            if(dto.getContact().equals(txtCustomerIdPO.getText())){
               isExist= true;
            }
        }
        if(!isExist){
            customerBo.save(new CustomerDto(
                    txtCustomerIdPO.getText(),
                    txtCustomerNamePO.getText(),
                    txtEmailPO.getText()
            ));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void backBtnOnAction(ActionEvent actionEvent) {

    }

    public void cancelBtnOnAction(ActionEvent actionEvent) {
        clearFields();
    }

    public void searchBtn1OnAction(ActionEvent actionEvent) {
        try {
            List<CustomerDto> list = customerBo.allCustomers();
            for (CustomerDto customerDto: list) {
                if(customerDto.getContact().equals(txtCustomerIdPO.getText())){
                    txtCustomerNamePO.setText(customerDto.getName());
                    txtEmailPO.setText(customerDto.getEmail());
                    return;
                }
            }
            new Alert(Alert.AlertType.ERROR,"No customer Data Found!...").show();
            clearFields();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
    }

    private void clearFields() {
        txtEmailPO.clear();
        txtCustomerNamePO.clear();
        txtItemNameCb.setValue("none");
        txtCustomerIdPO.clear();
        txtDescriptionPO.clear();
    }

    public void backBtnOnAvtion(MouseEvent mouseEvent) {
    }

}
