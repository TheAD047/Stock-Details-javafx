module com.example.assignment2gc200489790 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.net.http;
    requires com.google.gson;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.annotation;

    opens com.example.assignment2gc200489790 to javafx.fxml, com.google.gson;
    opens com.example.assignment2gc200489790.Controllers to javafx.fxml, javafx.base;
    opens com.example.assignment2gc200489790.Models to javafx.fxml, com.google.gson, com.fasterxml.jackson.databind, javafx.base;

    exports com.example.assignment2gc200489790;
}