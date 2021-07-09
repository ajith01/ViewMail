package Client.Controller;

import Client.EmailManager;
import Client.GUI.GUIManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeView;
import javafx.scene.web.WebView;

public class MainWindowController extends Controller{

    @FXML
    private TreeView<?> EmailsTree;

    @FXML
    private TableView<?> emailsTables;

    @FXML
    private WebView emailsWeb;

    public MainWindowController(EmailManager emailManager, GUIManager guiManager, String fxmlUrl) {
        super(emailManager, guiManager, fxmlUrl);
    }

    @FXML
    void optionsAction() {
        guiManager.showOptionsWindow();

    }

}
