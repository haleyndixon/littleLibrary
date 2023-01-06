package littleLibrary;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book {
    private final Integer id;
    private final String title;
    private final String author;
    private final String finish;
    private final Integer pages;
    private final Integer rating;

    //constructor with book object parameters
    public Book(Integer id, String title, String author, String finish, Integer pages, Integer rating) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.finish = finish;
        this.pages = pages;
        this.rating = rating;

    }
    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getFinish() {
        return finish;
    }
    public Integer getPages() {
        return pages;
    }
    public Integer getRating() {
        return rating;
    }
    //methods used by books
    public void insertBook(byte[] cover) {

        //connect to the database using the connection class
        Connection connection = null;

        //insert book into database
        try {
            //establish connection
            connection = DatabaseTings.getConnection();

            //create sql insert statement
            String sql = "INSERT INTO Entries (Title, Author, Finish, Pages, Rating, Cover) values (?, ?, ?, ?, ?, ?)";

            //create prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            {
                //set parameters of prepared statement using book objects data
                preparedStatement.setString(1, this.getTitle());
                preparedStatement.setString(2, this.getAuthor());
                preparedStatement.setObject(3, this.getFinish());
                preparedStatement.setInt(4, this.getPages());
                preparedStatement.setInt(5, this.getRating());
                preparedStatement.setBytes(6, cover);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
