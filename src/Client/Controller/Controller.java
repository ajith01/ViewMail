package Client.Controller;

import Client.EmailManager;
import Client.GUI.GUIManager;

public abstract class AbstractController {

    private EmailManager emailManager;
    private GUIManager guiManager;
    private String fxmlUrl;

    public AbstractController(EmailManager emailManager, GUIManager guiManager, String fxmlUrl) {
        this.emailManager = emailManager;
        this.guiManager = guiManager;
        this.fxmlUrl = fxmlUrl;
    }
}
