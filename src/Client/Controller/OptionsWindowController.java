package Client.Controller;

import Client.EmailManager;
import Client.GUI.Colours;
import Client.GUI.FontSize;
import Client.GUI.GUIManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends Controller implements Initializable {
    //initableziable method will be called right after it is created to update the methods

    @FXML
    private Slider fontSize;

    @FXML
    private ChoiceBox<FontSize> fontType;

    @FXML
    private ChoiceBox<Colours> themeOption;

    public OptionsWindowController(EmailManager emailManager, GUIManager guiManager, String fxmlUrl) {
        super(emailManager, guiManager, fxmlUrl);
    }

    @FXML
    void applyChanges() {
        guiManager.setTheme(themeOption.getValue());
        guiManager.setFontSize(FontSize.values()[(int)fontSize.getValue()]);
        System.out.println(guiManager.getTheme());
        System.out.println(guiManager.getFontSize());
        guiManager.updateStyles();

    }

    @FXML
    void cancelChanges() {
        Stage stage = (Stage) fontSize.getScene().getWindow();
        guiManager.closeStage(stage);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GiveThemeOptions();
        GiveFontOptions();

    }

    private void GiveFontOptions() {
        fontSize.setMin(0);
        fontSize.setMax(FontSize.values().length-1);
        fontSize.setValue(guiManager.getFontSize().ordinal());
        fontSize.setMajorTickUnit(1);
        fontSize.setMinorTickCount(0);
        fontSize.setBlockIncrement(1);
        fontSize.setSnapToTicks(true);
        fontSize.setShowTickLabels(true);
        fontSize.setShowTickMarks(true);
        fontSize.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int i = aDouble.intValue();
                return FontSize.values()[i].toString();
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });
        fontSize.valueProperty().addListener(((observableValue, oldVal, newVal) -> {
            fontSize.setValue(newVal.intValue());
        } ));

    }

    private void GiveThemeOptions() {
        themeOption.setItems(FXCollections.observableArrayList(Colours.values()));
        themeOption.setValue(guiManager.getTheme());
    }



}
