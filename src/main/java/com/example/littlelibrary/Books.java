package com.example.littlelibrary;

public class Books {

    private final String title;
    private final String author;
    private final String finish;
    private final String pageCount;
    private final String rating;
    private final int id;

    public Books(String title, String author, String finish, String pageCount, String rating, int id) {
        this.title = title;
        this.author = author;
        this.finish = finish;
        this.pageCount = pageCount;
        this.rating = rating;
        this.id = id;
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










