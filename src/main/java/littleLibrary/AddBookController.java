package littleLibrary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddBookController {

    @FXML TextField titleField = new TextField();
    @FXML TextField authorField = new TextField();
    @FXML DatePicker finishField = new DatePicker();
    @FXML TextField pagesField = new TextField();
    @FXML TextField ratingField = new TextField();

    NavigationManager manager = new NavigationManager();

    @FXML public void backBtn(ActionEvent event) {
        manager.switchScene("File:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\GUI\\AddBookPage.fxml");
        manager.backButton("File:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\GUI\\Main Page.fxml");
    }

    @FXML public void addNewEntry(ActionEvent event) {
        Integer id = null;
        String title = titleField.getText();
        String author = authorField.getText();
        String finish = String.valueOf(finishField.getValue());
        Integer pages = Integer.valueOf(pagesField.getText());
        Integer rating = Integer.valueOf(ratingField.getText());

        //create new book object and set parameters using the constructor
        Book book = new Book(null, title, author, finish, pages, rating);

        book.insertBook();

    }









//    public void setBook(Book book, ActionEvent actionEvent) {
//        this.book = book;
//
//        //bind textfield data to book object
//        titleField.textProperty().bindBidirectional(book.titleProperty());
//        authorField.textProperty().bindBidirectional(book.authorProperty());
//        finishField.valueProperty().bindBidirectional(book.finishProperty());
//        countField.textProperty().bindBidirectional(book.pagesProperty(), new StringConverter<Number>() {
//            //convert textfield string objects to an integer within the book object
//            @Override
//            public String toString(Number number) {
//                return number.toString();
//            }
//
//            @Override
//            public Number fromString(String string) {
//                return Integer.parseInt(string);
//            }
//        });
//        ratingField.textProperty().bindBidirectional(book.ratingProperty(), new StringConverter<Number>() {
//            //convert textfield string objects to an integer within the book object
//            @Override
//            public String toString(Number number) {
//                return number.toString();
//            }
//            @Override
//            public Number fromString(String string) {
//                return Integer.parseInt(string);
//            }
//        });
//    }

//
//   public void insertData() throws SQLException{
//
//
//        }
//    }

}




//        finishField.setValue(LocalDate.now());
//                LocalDate date = finishField.getValue();
//
//                if (titleField.getText().isEmpty() || authorField.getText().isEmpty() || finishField.getValue() == null || countField.getText().isEmpty() || ratingField.getText().isEmpty()) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setHeaderText(null);
//                alert.setContentText("Please fill in data");
//                alert.showAndWait();
//                } else {
//                insert();
//                }

//
//    private void insert() throws SQLException {
//        conn = DatabaseTings.getConnection();
//        statement = conn.createStatement();
//        statement.executeUpdate("insert into Entries (Title, Author, Finish, Pages, Rating)\n" +
//                "values ('"+titleField.getText()+"', '"+authorField.getText()+"', '"+finishField.getValue()+"', '"+countField.getText()+"', '"+ratingField.getText()+"');");
//        System.out.println("working so far");
//
//    }