package Client;

import Client.GUI.GUIManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLauncher extends Application {
    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GUIManager guiManager = new GUIManager(new EmailManager());
        guiManager.showLoginWindow();
        guiManager.updateStyles();

//        Parent parent = FXMLLoader.load(getClass().getResource("GUI/MainWindow.fxml"));
//
//        Scene scene = new Scene(parent,465,380);
//        primaryStage.setScene(scene);
//        primaryStage.show();


    }
}
