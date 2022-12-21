package littleLibrary;

public class Books {

    public Books(String title, String author, String finish, String pages, String rating, int id) {
        this.title = title;
        this.author = author;
        this.finish = finish;
        this.pages = pages;
        this.rating = rating;
        this.id = id;
    }

    public final String title;
    public final String author;
    public final String finish;
    public final String pages;
    public final String rating;
    public final int id;


    @Override
    public String toString() {
        return "Books{" +
                "Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Finish='" + finish + '\'' +
                ", Pages='" + pages + '\'' +
                ", Rating='" + rating + '\'' +
                ", id='" + id + '\'' +
                '}';
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

    public String getPages() {
        return pages;
    }

    public String getRating() {
        return rating;
    }
}










