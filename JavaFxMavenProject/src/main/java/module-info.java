module com.example {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires java.desktop;

    opens com.example to javafx.fxml;
    exports com.example;
}
