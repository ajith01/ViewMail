package Client.Controller;

import Client.EmailManager;
import Client.GUI.GUIManager;

public abstract class Controller {

    private EmailManager emailManager;
    protected GUIManager guiManager;
    private String fxmlUrl;

    public Controller(EmailManager emailManager, GUIManager guiManager, String fxmlUrl) {
        this.emailManager = emailManager;
        this.guiManager = guiManager;
        this.fxmlUrl = fxmlUrl;
    }

    public String getFXMLLinke(){
        return this.fxmlUrl;
    }


}
