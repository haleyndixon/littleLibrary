package com.example.littlelibrary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AddBookController {

    @FXML
    Button saveBtn;
    @FXML
    TextField titleField;
    @FXML TextField authorField;
    @FXML TextField finishField;
    @FXML TextField countField;
    @FXML TextField ratingField;

    Connection conn;
    Statement statement = null;

    String query = null;
    PreparedStatement preparedStatement = null;
    private boolean update;
    public void addNewEntry(ActionEvent event) throws SQLException {

        if (titleField.getText().isEmpty()||authorField.getText().isEmpty()||finishField.getText().isEmpty()||countField.getText().isEmpty()||ratingField.getText().isEmpty()) {
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
                "values ('"+titleField.getText()+"', '"+authorField.getText()+"', '"+finishField.getText()+"', '"+countField.getText()+"', '"+ratingField.getText()+"');");
        System.out.println("working so far");

    }

    private void getQuery() {
        if (update == false) {
            query = "insert into Entries (Title, Author, Finish, Pages, Rating)\n" +
                    "values (?, ?, ?, ?, ?);";
        } else
            query = "";
    }


}
