package Client.Controller;

import Client.EmailManager;
import Client.GUI.GUIManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginWindowController extends Controller {

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

    @FXML
    private Button loginButton;

    @FXML
    private Label errorLabel;


    @FXML
    void loginOnAction() {

        guiManager.showMainWindow();
        //doesnt have abuilt in method to get the stage
        Stage stage = (Stage) passwordField.getScene().getWindow();
        guiManager.closeStage(stage);

    }
    public LoginWindowController(EmailManager emailManager, GUIManager guiManager, String fxmlUrl) {
        super(emailManager, guiManager, fxmlUrl);
    }

}
