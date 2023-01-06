package PageControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import littleLibrary.Book;
import littleLibrary.DatabaseTings;

import java.sql.*;

public class BrowseController {

    ObservableList<Book> BookList = FXCollections.observableArrayList();

    public void initialize() throws SQLException {
        loadData();
    }

    @FXML
    public TableView<Book> exampleTable;
    @FXML
    public TableColumn<Book, Integer> idColumn;
    @FXML
    public TableColumn<Book, String> titleColumn;
    @FXML
    public TableColumn<Book, String> authorColumn;
    @FXML
    public TableColumn<Book, String> finishDateColumn;
    @FXML
    public TableColumn<Book, String> pageCountColumn;
    @FXML
    public TableColumn<Book, String> ratingColumn;



    public void loadData() throws SQLException {

        refreshTable();

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("Title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("Author"));
        finishDateColumn.setCellValueFactory(new PropertyValueFactory<>("Finish"));
        pageCountColumn.setCellValueFactory(new PropertyValueFactory<>("Pages"));
        ratingColumn.setCellValueFactory(new PropertyValueFactory<>("Rating"));
    }

    @FXML public void deleteEntry(ActionEvent actionEvent) throws SQLException {

        Connection connection;

        //get the selected items from table and delete
        ObservableList<Book> selectedItems = exampleTable.getSelectionModel().getSelectedItems();
        exampleTable.getItems().removeAll(selectedItems);

        //create an object to execute queries
        connection = DatabaseTings.getConnection();
        Statement statement = connection.createStatement();
        for (Book id : selectedItems) {
            statement.executeUpdate("DELETE FROM Entries WHERE id = " + id.getId());
        }


    }
    public void refreshTable() throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Connection conn = DatabaseTings.getConnection();


        preparedStatement = conn.prepareStatement("select * from Entries");
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            BookList.add(new Book(

                    resultSet.getInt("id"),
                    resultSet.getString("Title"),
                    resultSet.getString("Author"),
                    resultSet.getString("Finish"),
                    resultSet.getInt("Pages"),
                    resultSet.getInt("Rating")
                    ));
            exampleTable.setItems(BookList);
        }
        preparedStatement.close();
        resultSet.close();

    }
}
