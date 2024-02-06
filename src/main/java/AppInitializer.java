import controller.LogInFormController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class AppInitializer extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("view/LogInForm.fxml"));
        Parent root = loader.load();


        LogInFormController logInController = loader.getController();
        Scene scene = new Scene(root);
        scene.setUserData(logInController);

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setTitle("System log in");
        primaryStage.show();
    }
}
