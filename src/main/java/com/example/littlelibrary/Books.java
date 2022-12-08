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

}










