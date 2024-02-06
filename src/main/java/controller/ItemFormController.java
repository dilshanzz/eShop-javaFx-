package controller;

import bo.BoFactory;
import bo.Custom.ItemBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dto.ItemDto;
import dto.tm.ItemTm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;
import java.util.List;

public class ItemFormController {
    @FXML
    private TableView<ItemTm> itemTableI;

    @FXML
    private TableColumn<?, ?> ColPNI;

    @FXML
    private TableColumn<?, ?> colCatI;

    @FXML
    private TableColumn<ItemTm, ImageView> ColImageI;

    @FXML
    private TableColumn<?, ?> colQtyI;

    @FXML
    private TableColumn<?, ?> colOptionI1;

    @FXML
    private JFXTextField txtQtyI;

    @FXML
    private JFXTextField txtCategoryI;

    @FXML
    private JFXTextField txtUrl;

    @FXML
    private JFXTextField txtProductnameI;

    ItemBo itemBo = BoFactory.getInstance().getBo(BoType.ITEM);

    public void initialize(){


        ColPNI.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCatI.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQtyI.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        colOptionI1.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadItemTable();
        itemTableI.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            setData(newValue);
        });
    }

    private void setData(ItemTm newValue) {
        if(newValue != null){
            txtProductnameI.setEditable(false);
            txtProductnameI.setText(newValue.getName());
            txtCategoryI.setText(newValue.getCategory());
            txtQtyI.setText(String.valueOf(newValue.getQuantity()));

        }
    }

    private void loadItemTable() {
        ObservableList<ItemTm> list = FXCollections.observableArrayList();
        try {
            List<ItemDto> list1 = itemBo.allItems();
            for (ItemDto dto: list1) {
                JFXButton btn = new JFXButton("Delete");
                ItemTm itemTm = new ItemTm(
                        dto.getName(),
                        dto.getCategory(),
                        dto.getQuantity(),
                        btn
                );
                list.add(itemTm);
                itemTableI.setItems(list);
                btn.setOnAction(actionEvent -> {
                    deleteItem(dto.getName());
                });
            }
        } catch (SQLException e) {
           e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void deleteItem(String name) {
        try {
            boolean isDeleted= itemBo.deleteItem(name);
            if(isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Delete complete").show();
                loadItemTable();
                clearFields();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void searchBtnItOnAction(ActionEvent actionEvent) {
        String name = txtProductnameI.getText();

        try {
            List<ItemDto> list = itemBo.allItems();
            for(int i=0; i<list.size(); i++){
                if(name.equals(list.get(i).getName())){
                   txtCategoryI.setText( list.get(i).getCategory());
                   txtQtyI.setText(String.valueOf(list.get(i).getQuantity()));
                  // break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void upBtnItOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdated = itemBo.updateItem(new ItemDto(
                    txtProductnameI.getText(),
                    txtCategoryI.getText(),
                    Integer.parseInt(txtQtyI.getText())
            ));
            if(isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Item Saved").show();
                loadItemTable();
                clearFields();

            }else{
                new Alert(Alert.AlertType.ERROR,"Something went Wrong !...").show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveBtnItOnAction(ActionEvent actionEvent) {
        try {
            if(txtQtyI.getText() != null) {
                boolean isUpdated = itemBo.saveItem(new ItemDto(
                        txtProductnameI.getText(),
                        txtCategoryI.getText(),
                        Integer.parseInt(txtQtyI.getText())
                ));
                if (isUpdated) {
                    new Alert(Alert.AlertType.INFORMATION, "Item Saved").show();
                    itemTableI.refresh();
                    loadItemTable();
                    clearFields();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Something went Wrong !...").show();
                }
            }else{
                new Alert(Alert.AlertType.ERROR,"Enter Quantity");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void refreshBtnItOnAction(ActionEvent actionEvent) {
        loadItemTable();
        itemTableI.refresh();
        clearFields();

    }

    private void clearFields() {
        txtProductnameI.clear();
        txtCategoryI.clear();
        txtUrl.clear();
        txtQtyI.clear();
        txtProductnameI.setEditable(true);
    }

    public void backBtnOnAvtion(MouseEvent mouseEvent) {

    }
}
