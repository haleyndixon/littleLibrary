package com.example.littlelibrary;

public class Books {

    public final String title;
    public final String author;
    public final String finish;
    public final String pageCount;
    public final String rating;

    public Books(String title, String author, String finish, String pageCount, String rating) {
        this.title = title;
        this.author = author;
        this.finish = finish;
        this.pageCount = pageCount;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Books{" +
                "Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Finish='" + finish + '\'' +
                ", Pages='" + pageCount + '\'' +
                ", Rating='" + rating + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getFinishDate() {
        return finish;
    }

    public String getPageCount() {
        return pageCount;
    }

    public String getRating() {
        return rating;
    }

















    //
//    @FXML public final TextField titleField;
//    @FXML public final TextField authorField;
//    @FXML public final TextField finishField;
//    @FXML public final TextField countField;
//    @FXML public final TextField ratingField;
//    @FXML public final TextField idField;
//
//    @Override
//    public String toString() {
//        return "Books{" +
//                "titleField=" + titleField +
//                ", authorField=" + authorField +
//                ", finishField=" + finishField +
//                ", countField=" + countField +
//                ", ratingField=" + ratingField +
//                ", idField=" + idField +
//                '}';
//    }
//
//    public TextField getTitleField() {
//        return titleField;
//    }
//
//    public TextField getAuthorField() {
//        return authorField;
//    }
//
//    public TextField getFinishField() {
//        return finishField;
//    }
//
//    public TextField getCountField() {
//        return countField;
//    }
//
//    public TextField getRatingField() {
//        return ratingField;
//    }
//
//    public TextField getIdField() {
//        return idField;
//    }
//
//    public Books(TextField titleField, TextField authorField, TextField finishField, TextField countField, TextField ratingField, TextField idField) {
//        this.titleField = titleField;
//        this.authorField = authorField;
//        this.finishField = finishField;
//        this.countField = countField;
//        this.ratingField = ratingField;
//        this.idField = idField;
//
//
//
//    }
}










