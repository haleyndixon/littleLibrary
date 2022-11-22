//package com.example.littlelibrary;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//import java.sql.*;
//import java.time.LocalDateTime;
//import java.util.Optional;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import com.example.littlelibrary.Books;
//
//
//public class BookEntryDAO {
//    private static final String tableName = "Entries";
//    private static final String titleColumn = "Title";
//    private static final String authorColumn = "Author";
//    private static final String finishDateColumn = "FinishDate";
//    private static final String pageCountColumn = "PageCount";
//    private static final String ratingColumn = "Rating";
//
//    private static final String idColumn = "id";
//    public static final ObservableList<Books> books;
//
//    static {
//        books = FXCollections.observableArrayList();
//        updateBooksFromDB();
//    }
//
//    public static ObservableList<Books> getBooks() {
//        return FXCollections.unmodifiableObservableList(books);
//    }
//
//    private static void updateBooksFromDB() {
//
//        String query = "SELECT * FROM " + tableName;
//
//        try (Connection connection = SqliteConnectionClass.getConnection()) {
//            PreparedStatement statement = connection.prepareStatement(query);
//            ResultSet rs = statement.executeQuery();
//            books.clear();
//            while (rs.next()) {
//                books.add(new Books(
//                        rs.getString(titleColumn),
//                        rs.getString(authorColumn),
//                        rs.getString(finishDateColumn),
//                        rs.getString(pageCountColumn),
//                        rs.getString(ratingColumn),
//                        rs.getInt(idColumn)));
//            }
//        } catch (SQLException e) {
//            Logger.getAnonymousLogger().log(
//                    Level.SEVERE,
//                    LocalDateTime.now() + ": Could not load book from database ");
//            books.clear();
//        }
//    }
//
//    public static void update(Books newBook) {
//        //udpate database
//        int rows = CRUDHelper.update(
//                tableName,
//                new String[]{titleColumn, authorColumn, finishDateColumn, pageCountColumn, ratingColumn},
//                new Object[]{newBook.getTitle(), newBook.getAuthor(), newBook.getFinishDate(), newBook.getPageCount(), newBook.getRating()},
//                new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR},
//                idColumn,
//                Types.INTEGER,
//                newBook.getId()
//        );
//        if (rows == 0)
//            throw new IllegalStateException("Book to be updated with id " + newBook.getId() + " didn't exist in database");
//
//    }
//
//    public static void insertBook(String title, String author, String finishDate, String pageCount, String rating) {
//        //update database
//        int id = (int) CRUDHelper.create(
//                tableName,
//                new String[]{"Title", "Author", "Finish Date", "Page Count", "Rating"},
//                new Object[]{title, author, finishDate, pageCount, rating},
//                new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR});
//
//        //update cache
//        books.add(new Books(
//                title,
//                author,
//                finishDate,
//                pageCount,
//                rating,
//                id
//        ));
//    }
//
//    public static void delete(int id) {
//        //update database
//        CRUDHelper.delete(tableName, id);
//
//    }
//}
//
////}
