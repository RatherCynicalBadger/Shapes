module com.example.shapes {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;

    opens com.example.shapes to javafx.fxml;
    exports com.example.shapes;
}