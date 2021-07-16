package Client.GUI;

import Client.Controller.Controller;
import Client.Controller.LoginWindowController;
import Client.Controller.MainWindowController;
import Client.Controller.OptionsWindowController;
import Client.EmailManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class GUIManager {
    private EmailManager emailManager;
    private ArrayList<Stage> activeStages;

    public GUIManager(EmailManager emailManager) {
        this.emailManager = emailManager;
        activeStages = new ArrayList<Stage>();
    }

    private Colours theme = Colours.Dark;
    private FontSize fontSize = FontSize.Medium;

    public Colours getTheme() {
        return theme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void setTheme(Colours theme) {
        this.theme = theme;
    }


    public void showLoginWindow(){
        System.out.println("Showing log in window");
        Controller controller = new LoginWindowController(emailManager,this,"LoginWindow.fxml");
        initializeStage(controller);
    }

    public void showMainWindow(){
        System.out.println("Showing main window");
        Controller controller = new MainWindowController(emailManager,this,"MainWindow.fxml");
        initializeStage(controller);
    }

    public void initializeStage(Controller controller){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(controller.getFXMLLinke()));
        loader.setController(controller);
        Parent parent;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);

    }

    public void showOptionsWindow(){
        System.out.println("options window called");
        Controller controller = new OptionsWindowController(emailManager,this,"Options.fxml");
        initializeStage(controller);
    }



    public void closeStage(Stage stage){
        stage.close();
        activeStages.remove(stage);

    }

    public void updateStyles() {
        for (Stage stage:activeStages){
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(Colours.getCSSPath(theme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCSSPath(fontSize)).toExternalForm());

        }
    }


}
