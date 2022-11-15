module com.example.assignment2gc200489790 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.assignment2gc200489790 to javafx.fxml;
    exports com.example.assignment2gc200489790;
}