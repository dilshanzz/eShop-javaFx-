package controller;

import bo.BoFactory;
import bo.Custom.OrderBo;
import bo.Custom.OrderDataBo;
import bo.Custom.UsedPartsBo;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dao.DaoFactory;
import dao.custom.OrderDao;
import dao.custom.OrderDataDao;
import dao.custom.PartDao;
import dao.util.BoType;
import dao.util.DaoType;
import dto.OrderDataDto;
import dto.OrderDto;
import dto.UsedPartsDto;
import dto.tm.OrderTm;
import dto.tm.UsedPartTm;
import entity.Orders;
import entity.Part;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderFormController {

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
    private TableColumn<?, ?> colAmountO;

    @FXML
    private TableColumn<?, ?> colScO;

    @FXML
    private TableColumn<?, ?> colPaO;

    @FXML
    private TableColumn<?, ?> colCustomercontactO;

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
    private TableView<UsedPartTm> partTableO;

    @FXML
    private TableColumn<?, ?> colPartCode1O;

    @FXML
    private TableColumn<?, ?> colPartNameO;

    @FXML
    private TableColumn<?, ?> colPartPriceO;

    @FXML
    private TableColumn<?, ?> colPartOPTION;

    @FXML
    private TableView<?> customerTableO;

    @FXML
    private TableColumn<?, ?> ColCustomerIdO;

    @FXML
    private TableColumn<?, ?> ColCustomerNameO;

    @FXML
    private TableColumn<?, ?> colEmailO;

    @FXML
    private Label lblPartAmountO;

    @FXML
    private Label lblTotalAmountO;

    @FXML
    private JFXComboBox combPartCodeO;

    @FXML
    private JFXComboBox combStatusO;

    @FXML
    private JFXTextField txtCatO;

    @FXML
    private JFXTextField txtScO;

    @FXML
    private JFXTextField txtQty;

    OrderBo orderBo = BoFactory.getInstance().getBo(BoType.ORDER);
    OrderDao orderDao = DaoFactory.getInstance().getDao(DaoType.ORDER);

    OrderDataDao orderDataDao = DaoFactory.getInstance().getDao(DaoType.ORDERDATA);

    PartDao partDao = DaoFactory.getInstance().getDao(DaoType.PART);
    OrderDataBo orderDataBo = BoFactory.getInstance().getBo(BoType.ORDERDATA);
    UsedPartsBo usedPartsBo = BoFactory.getInstance().getBo(BoType.USEDPARTS);


    public void initialize(){
        loadOrderTable();
        setStatus();
        setPartPrice();
        setPartCodes();
    }

    private void loadOrderTable() {
        ObservableList<OrderTm> list = FXCollections.observableArrayList();
        try {
            List<OrderDto> list1 = orderBo.allOrders();
            for (OrderDto dto: list1) {

                OrderTm orderTm = new OrderTm(
                        dto.getOrderId(),
                        dto.getOrderId(),
                        dto.getDescription(),
                        dto.getCategory(),
                        dto.getDate(),
                        dto.getStatus(),
                        dto.getContact(),
                        dto.getCname(),
                        dto.getEmail()
                );
                list.add(orderTm);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchBtnOOnAction(ActionEvent actionEvent) {
        try {
            List<Orders> list = orderDao.getAll();
            for (Orders orders: list) {
                if(txtOdrIdO.getText().equals(orders.getOrderId())){

                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public double setPartPrice(){
        combPartCodeO.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, code) -> {
            try {
                List<Part> list = partDao.getAll();
                for (Part part: list) {
                    if(combPartCodeO.getValue().toString().equals(part)){
                        lblPartAmountO.setText(String.valueOf(part.getPrice()));
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        return 0;
    }
    public void setStatus(){
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("Processing");
        list.add("Complete");

        combStatusO.setItems(list);

    }
    public void setPartCodes(){

        try {
            ObservableList list = FXCollections.observableArrayList();
            List<Part> list1 = partDao.getAll();

            for (Part part: list1) {
                list.add(part.getCode()
                 );

            }
            combPartCodeO.setItems(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void backBtnOnAction(ActionEvent actionEvent) {

    }

    public void refreshBtnOOnAction(ActionEvent actionEvent) {

    }

    public void upBtnCOnAction(ActionEvent actionEvent) {

    }

    public void saveBtnOnAction(ActionEvent actionEvent) {
        double price = 0;

        List<UsedPartsDto> list = new ArrayList<>();
        list.add(new UsedPartsDto(
                combPartCodeO.getValue().toString(),
               Integer.parseInt( txtQty.getText()),
                Double.parseDouble(lblPartAmountO.getText())
        ));
       // boolean isSaved = usedPartsBo.save()
        for (UsedPartsDto dto : list) {
            price +=dto.getPrice() * Integer.parseInt(txtQty.getText());
        }
        try {
            boolean isSaved = orderDataBo.save(new OrderDataDto(
                    txtOdrIdO.getText(),
                    Double.parseDouble(lblTotalAmountO.getText()),
                    Double.parseDouble(txtScO.getText()),
                    price



            ));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
