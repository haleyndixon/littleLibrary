package com.example.littlelibrary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class BrowseController {

    public void initialize() {
        loadData();
    }


    @FXML public TableView<Books> exampleTable;
    @FXML public TableColumn<Books, String> titleColumn;
    @FXML public TableColumn<Books, String> authorColumn;
    @FXML public TableColumn<Books, String> finishDateColumn;
    @FXML public TableColumn<Books, String> pageCountColumn;
    @FXML public TableColumn<Books, String> ratingColumn;
    @FXML public TableColumn<Books, Integer> idColumn;


    String query = null;
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Books book = null;

    ObservableList<Books> BookList = FXCollections.observableArrayList();

    public void loadData() {

        conn = SqliteConnectionClass.getConnection();

        refreshTable();
        
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
        finishDateColumn.setCellValueFactory(new PropertyValueFactory<>("Finish"));
        pageCountColumn.setCellValueFactory(new PropertyValueFactory<>("Pages"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("Rating"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

    }

    @FXML public void deleteEntry(ActionEvent actionEvent) throws SQLException {
        Button delete;
        //get the selected items from table and delete
        ObservableList<Books> selectedItems = exampleTable.getSelectionModel().getSelectedItems();
        exampleTable.getItems().removeAll(selectedItems);

        //create an object to execute queries
        conn = SqliteConnectionClass.getConnection();
        Statement statement = conn.createStatement();
        for (Books item : selectedItems) {
            statement.executeUpdate("DELETE FROM Entries WHERE id = " + item.getTitle());
        }


    }

    public void refreshTable() {

        try {
            query = "select * from Entries;";
            preparedStatement = conn.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                BookList.add(new Books(
                        resultSet.getString("Title"),
                        resultSet.getString("Author"),
                        resultSet.getString("Finish"),
                        resultSet.getString("Pages"),
                        resultSet.getString("Rating"),
                        resultSet.getInt("id")
                        ));
                exampleTable.setItems(BookList);
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete() {
    }

    private void getQuery() {
    }
}
