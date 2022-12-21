package littleLibrary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class AddBookController {

    @FXML TextField titleField = new TextField();
    @FXML TextField authorField = new TextField();
    @FXML DatePicker finishField = new DatePicker();
    @FXML TextField countField = new TextField();
    @FXML TextField ratingField = new TextField();
    Connection conn;
    Statement statement = null;

    public void addNewEntry() throws SQLException {

        finishField.setValue(LocalDate.now());
        LocalDate date = finishField.getValue();

        if (titleField.getText().isEmpty() || authorField.getText().isEmpty() || finishField.getValue() == null || countField.getText().isEmpty() || ratingField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill in data");
            alert.showAndWait();
        } else {
            insert();
        }

    }

    private void insert() throws SQLException {
        conn = SqliteConnectionClass.getConnection();
        statement = conn.createStatement();
        statement.executeUpdate("insert into Entries (Title, Author, Finish, Pages, Rating)\n" +
                "values ('"+titleField.getText()+"', '"+authorField.getText()+"', '"+finishField.getValue()+"', '"+countField.getText()+"', '"+ratingField.getText()+"');");
        System.out.println("working so far");

    }

}
