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

public class AdmindashBoardFormcontroller {

    @FXML
    private AnchorPane adbPane;

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


    public void itemBtn1OnAction(ActionEvent actionEvent) {

    }
    public void cusBtn1OnAction(ActionEvent actionEvent)  {
        Stage stage = (Stage) adbPane.getScene().getWindow();

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
    public void logoutBtn1OnAction(ActionEvent actionEvent) {

    }

    public void cpBtn1OnAction(ActionEvent actionEvent) {

    }

    public void muBtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) adbPane.getScene().getWindow();

        try {
            Parent root =  FXMLLoader.load(getClass().getResource("/view/UserMangementForm.fxml"));
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

    public void inventBtn1OnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) adbPane.getScene().getWindow();
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

    public void addOdrBtn1OnAction(ActionEvent actionEvent) {

    }


    public void orderBtn1Onaction(ActionEvent actionEvent) {
        Stage stage = (Stage) adbPane.getScene().getWindow();

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

    public void reportsBtnOnaction(ActionEvent actionEvent) {

    }
}
