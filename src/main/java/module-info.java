module com.example.littlelibrary {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires  javafx.graphics;
requires org.xerial.sqlitejdbc;


    opens com.example.littlelibrary to javafx.fxml;
//    opens com.example.littlelibrary to javafx.base;
    exports com.example.littlelibrary;
}