package com.example.littlelibrary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.*;


public class HelloController {
    
    public void initialize() {
        loadData();
    }

    @FXML public TableView<Books> exampleTable;
    @FXML public TableColumn<Books, String> titleColumn;
    @FXML public TableColumn<Books, String> authorColumn;
    @FXML public TableColumn<Books, String> finishDateColumn;
    @FXML public TableColumn<Books, String> pageCountColumn;
    @FXML public TableColumn<Books, String> ratingColumn;

    String query = null;
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    Books book = null;
    
    ObservableList <Books> BookList = FXCollections.observableArrayList();

    @FXML Button saveBtn;
    @FXML TextField titleField;
    @FXML TextField authorField;
    @FXML TextField finishField;
    @FXML TextField countField;
    @FXML TextField ratingField;
    
    public void loadData() {

        conn = SqliteConnectionClass.getConnection();

        refreshTable();

        titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
        finishDateColumn.setCellValueFactory(new PropertyValueFactory<>("Finish"));
        pageCountColumn.setCellValueFactory(new PropertyValueFactory<>("Pages"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("Rating"));

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
                        resultSet.getString("Rating")

                ));
                exampleTable.setItems(BookList);
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void addNewEntry(ActionEvent event) {

        loadData();

        Connection conn;
        Statement stmt = null;
        String title = titleField.getText();
        String author = authorField.getText();
        String finishDate = finishField.getText();
        String pageCount = countField.getText();
        String rating = ratingField.getText();

        if (title.isEmpty()||author.isEmpty()||finishDate.isEmpty()||pageCount.isEmpty()||rating.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please fill in data");
            alert.showAndWait();
        } else {
            getQuery();
            insert();
        }


    }

    private void insert() {
    }

    private void getQuery() {
    }

    @FXML Button addBtn;
    @FXML Button trackBtn;
    @FXML Button summaryBtn;
    @FXML Button browseBtn;

    public void addBtn(ActionEvent event) throws Exception {

    }

    public void trackBtn(ActionEvent event) throws Exception {

    }

    public void summaryBtn(ActionEvent event) throws Exception {

    }

    public void browseBtn(ActionEvent event) throws Exception {
        try {
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(new URL("file:\\C:\\Users\\haley\\littleLibraryApp\\src\\main\\resources\\com\\example\\littleLibraryApp\\submitBook.fxml"));
            Parent root1 = (Parent) loader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }




    }

