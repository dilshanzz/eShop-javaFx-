package controller;

import bo.BoFactory;
import bo.Custom.OrderBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.OrderDto;
import dto.tm.OrderTm;
import entity.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.List;

public class OrderDataFormController {

    @FXML
    private TableView<OrderTm> odrTableO;

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
    private JFXTextField txtCatO;

    @FXML
    private JFXTextField txtStatusO;

    OrderBo orderBo = BoFactory.getInstance().getBo(BoType.ORDER);
    public void initialize(){
        colOdrIdO.setCellValueFactory(new  PropertyValueFactory<>("orderId"));
        colItemNameO.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        colItemDescriptionO.setCellValueFactory(new PropertyValueFactory<>("description"));
        colStatus2.setCellValueFactory(new PropertyValueFactory<>("category"));
        colDateO.setCellValueFactory(new PropertyValueFactory<>("date"));
        colStatusO.setCellValueFactory(new PropertyValueFactory<>("status"));
        colCustomercontactO.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colCusName.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colOptionO11.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadOrderTable();

        odrTableO.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(OrderTm newValue) {
        txtOdrIdO.setText(newValue.getOrderId());
        txtItemNameO.setText(newValue.getItemName());
        txtDescripO.setText(newValue.getDescription());
        txtCatO.setText(newValue.getCategory());
        txtDateO.setText(newValue.getDate());
        txtStatusO.setText(newValue.getDate());

    }

    private void loadOrderTable() {
        ObservableList<OrderTm> list = FXCollections.observableArrayList();
        try {
            List<OrderDto> lis2 = orderBo.allOrders();
            for (OrderDto orderDto: lis2) {
                JFXButton jfxButton = new JFXButton("Delete");
                OrderTm orderTm = new OrderTm(

                        orderDto.getCname(),
                        orderDto.getOrderId(),
                        orderDto.getContact(),
                        orderDto.getItemName(),
                        orderDto.getDescription(),
                        orderDto.getCategory(),
                        orderDto.getDate(),
                        orderDto.getStatus(),
                        orderDto.getEmail(),
                        jfxButton



                );
                System.out.println(orderDto.getOrderId());
                System.out.println(orderDto.getCategory());
                System.out.println(orderDto.getDate());
                System.out.println(orderDto.getDescription());
                System.out.println(orderDto.getContact());
                System.out.println(orderDto.getEmail());
                System.out.println(orderDto.getItemName());
                System.out.println(orderDto.getStatus());
                System.out.println(orderDto.getEmail());
                System.out.println(orderDto.getCname());
                jfxButton.setOnAction(actionEvent -> {
                   if(orderDto.getStatus().equals("Pending")){
                       deleteOrder(orderDto.getCname());
                   }


                });
                list.add(orderTm);
            }
            odrTableO.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteOrder(String orderId) {
        try {
            boolean isDeleted = orderBo.delete(orderId);
            if(isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Order Deleted.").show();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong.").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchBtnOOnAction(ActionEvent actionEvent) {
    }

    public void backBtnOnAction(ActionEvent actionEvent) {
    }

    public void refreshBtnOOnAction(ActionEvent actionEvent) {
    }

}
