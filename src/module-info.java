module ViewMail {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;
    requires javafx.graphics;

    opens Client;
    opens Client.GUI;
    opens Client.Controller;
//    opens Client.Model;

}