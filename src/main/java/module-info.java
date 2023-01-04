module littleLibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires  javafx.graphics;
    requires org.xerial.sqlitejdbc;
    requires java.desktop;


    opens littleLibrary to javafx.fxml, javafx.base;
    exports littleLibrary;
    exports PageControllers;
    opens PageControllers to javafx.base, javafx.fxml;
}