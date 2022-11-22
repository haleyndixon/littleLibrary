package com.example.littlelibrary;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelloController extends  SqliteConnectionClass{

//    @FXML public TableView<Books> exampleTable;
//    @FXML public TableColumn<Books, String> titleColumn;
//    @FXML public TableColumn<Books, String> authorColumn;
//    @FXML public TableColumn<Books, String> finishDateColumn;
//    @FXML public TableColumn<Books, String> pageCountColumn;
//    @FXML public TableColumn<Books, String> ratingColumn;
//
//    @FXML public TableColumn<Books, Integer> idColumn;
    @FXML Button saveBtn;
    @FXML TextField titleField;
    @FXML TextField authorField;
    @FXML TextField finishField;
    @FXML TextField countField;
    @FXML TextField ratingField;

    @FXML TextField idField;




    public void addNewEntry(ActionEvent event) {

        Connection conn;
        Statement stmt = null;

        try {
            conn = SqliteConnectionClass.getConnection();
            stmt = conn.createStatement();
            stmt.execute("INSERT INTO Entries ('Title', 'Author', 'Finish Date', 'Page Count', 'Rating', 'ID') VALUES ('"+titleField.getText()+"', '"+authorField.getText()+"', '"+finishField.getText()+"', '"+countField.getText()+"', '"+ratingField.getText()+"', '"+idField.getText()+"')");
            System.out.println(" SUCCESS!\n");

        
      
        } catch (SQLException e) {
            Logger.getLogger(SqliteConnectionClass.class.getName()).log(Level.SEVERE, null, e);
        }

















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
//    }
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


    }
    }


//        SqliteConnectionClass connection = new SqliteConnectionClass();
//        Connection conn = getConnection();
//        String entry = (("INSERT INTO BookEntry ('Title','Author','Finish Date', 'Page Count', 'Rating') VALUES (" + titleField.getText() + ", " + authorField.getText() + ", " + finishField.getText() + ", " + countField.getText() + ", " + ratingField.getText() + ")"));
//        Statement statement = conn.createStatement();
//        statement.executeUpdate(entry);