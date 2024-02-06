package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DefaultUserDashBoardFormController {

    @FXML
    private AnchorPane udbPane;

    @FXML
    private Label txtTime2;

    public void initialize() {
        calculateTime();
    }
    private void calculateTime() {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.ZERO,
                actionEvent -> txtTime2.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
        ), new KeyFrame(Duration.seconds(1)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void orderBtn2Onaction(ActionEvent actionEvent) {
        Stage stage = (Stage) udbPane.getScene().getWindow();

        try {
            Parent root =  FXMLLoader.load(getClass().getResource("/view/OrderForm.fxml"));
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

    public void itemBtn2OnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) udbPane.getScene().getWindow();

        try {
            Parent root =  FXMLLoader.load(getClass().getResource("/view/ItemForm.fxml"));
            Scene scene = new Scene(root);
            if (scene != null) {

                scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                stage.setScene(scene);
                stage.setTitle("View Items");
                stage.show();
            } else {
                System.err.println("Error: Scene is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cusBtn2OnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) udbPane.getScene().getWindow();

        try {
            Parent root =  FXMLLoader.load(getClass().getResource("/view/CustomerForm.fxml"));
            Scene scene = new Scene(root);
            if (scene != null) {

                scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                stage.setScene(scene);
                stage.setTitle("View Customers");
                stage.show();
            } else {
                System.err.println("Error: Scene is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void inventBtn2OnAction(ActionEvent actionEvent) {

        Stage stage = (Stage) udbPane.getScene().getWindow();
        try {
            Parent root =  FXMLLoader.load(getClass().getResource("/view/PartInfoForm.fxml"));
            Scene scene = new Scene(root);
            if (scene != null) {
                scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                stage.setScene(scene);
                stage.setTitle("Part Information");
                stage.show();
            } else {
                System.err.println("Error: Scene is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addOdrBtn2OnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) udbPane.getScene().getWindow();

        try {
            Parent root =  FXMLLoader.load(getClass().getResource("/view/PlaceOrderForm.fxml"));
            Scene scene = new Scene(root);
            if (scene != null) {

                scene.getStylesheets().add(getClass().getResource("/button1.css").toExternalForm());

                stage.setScene(scene);
                stage.setTitle("View Customers");
                stage.show();
            } else {
                System.err.println("Error: Scene is null");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cpBtn2OnAction(ActionEvent actionEvent) {
    }

    public void logoutBtn2OnAction(ActionEvent actionEvent) {
    }
}
