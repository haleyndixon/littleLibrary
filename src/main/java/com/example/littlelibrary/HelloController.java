package com.example.littlelibrary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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


//
//    private Dialog<Books> createBookDialog (Books books) {
//        Dialog<Books> dialog = new Dialog<>();
//        dialog.setTitle("Add Dialog");
//        dialog.setHeaderText("Add a new book to the database");
//        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL);
//        Stage dialogWindow = (Stage) dialog.getDialogPane().getScene().getWindow();
//
//        GridPane grid = new GridPane();
//        grid.setHgap(10);
//        grid.setVgap(10);
//        grid.setPadding(new Insets(20, 150, 10, 10));
//
//        TextField title = new TextField();
//        title.setPromptText("Title");
//        TextField author = new TextField();
//        author.setPromptText("Author");
//        TextField finishDate = new TextField();
//        finishDate.setPromptText("Finish Date");
//        TextField pageCount = new TextField();
//        pageCount.setPromptText("Page Count");
//        TextField rating = new TextField();
//        rating.setPromptText("Rating");
//
//        grid.add(new Label("Title:"), 0, 0);
//        grid.add(title, 1, 0);
//        grid.add(new Label("Author:"), 0, 1);
//        grid.add(author, 1, 1);
//        grid.add(new Label("Finish Date:"), 0, 2);
//        grid.add(finishDate, 1, 2);
//        grid.add(new Label("Page Count:"), 0, 3);
//        grid.add(pageCount, 1, 3);
//        grid.add(new Label("Rating:"), 0, 4);
//        grid.add(rating, 1, 4);
//        dialog.getDialogPane().setContent(grid);
//
//
//        dialog.setResultConverter(dialogButton -> {
//            if (dialogButton == ButtonType.OK) {
//                int id = -1;
//                if (books != null) id = books.getId();
//                return new Books(title.getText(), author.getText(), finishDate.getText(), pageCount.getText(), rating.getText(), id);
//            }
//            return null;
//        });
//        if (books != null) {
//            title.setText(books.getTitle());
//            author.setText(books.getAuthor());
//            finishDate.setText(books.getFinishDate());
//            pageCount.setText(books.getPageCount());
//            rating.setText(books.getRating());
//
//        }
//        return dialog;
//    }
//
//
//    }
//
//   public void deleteBook(ActionEvent event) {
//        for (Books books : exampleTable.getSelectionModel().getSelectedItems()) {
//           BookEntryDAO.delete(books.getId());
//        }
//   }


//












//
//
//        try {
////            conn = SqliteConnectionClass.getConnection();
//            stmt = conn.createStatement();
//            System.out.println("SUCCESSFUL CONNECTION!\n");
//            stmt.executeUpdate("INSERT INTO Entries ('Title', 'Author', 'Finish', 'Pages', 'Rating') VALUES ('"+titleField.getText()+"', '"+authorField.getText()+"', '"+finishField.toString()+"','"+countField.getText()+"','"+ratingField.toString()+"'");
//
//
//
//
//        } catch (SQLException e) {
//            Logger.getLogger(SqliteConnectionClass.class.getName()).log(Level.SEVERE, null, e);
//        }

//        stmt.execute("INSERT INTO Entries ('Title', 'Author', 'Finish Date', 'Page Count', 'Rating') VALUES ("+new Books(titleField.getText(),
//                authorField.getText(),
//                finishField.getText(),
//                countField.getText(),
////                ratingField.getText())+")");

//
//        finishDateColumn.setCellValueFactory(new PropertyValueFactory<>("Finish Date"));
//        pageCountColumn.setCellValueFactory(new PropertyValueFactory<>("Page Count"));
//        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("Rating"));
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("ID"));
//
//        exampleTable.setItems();
//


//    public void initialize(){
//        exampleTable.setItems(BookEntryDAO.getBooks());
//
//        titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
//        authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
//        finishDateColumn.setCellValueFactory(new PropertyValueFactory<>("Finish Date"));
//        pageCountColumn.setCellValueFactory(new PropertyValueFactory<>("Page Count"));
//        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("Rating"));
//        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));


    }



//        SqliteConnectionClass connection = new SqliteConnectionClass();
//        Connection conn = getConnection();
//        String entry = (("INSERT INTO BookEntry ('Title','Author','Finish Date', 'Page Count', 'Rating') VALUES (" + titleField.getText() + ", " + authorField.getText() + ", " + finishField.getText() + ", " + countField.getText() + ", " + ratingField.getText() + ")"));
//        Statement statement = conn.createStatement();
//        statement.executeUpdate(entry);