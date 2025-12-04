module Modul6 {
    requires javafx.controls;
    requires javafx.fxml;

    opens Controller to javafx.fxml;
    opens Model to javafx.fxml;
    opens View to javafx.fxml;
    opens application to javafx.fxml;

    exports application;
}
