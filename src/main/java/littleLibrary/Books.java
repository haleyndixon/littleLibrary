package littleLibrary;

public class Books {

    private final String title;
    private final String author;
    private final String finish;
    private final String pages;
    private final String rating;
    private final Integer id;


    public Books(String title, String author, String finish, String pages, String rating, Integer id) {
        this.title = title;
        this.author = author;
        this.finish = finish;
        this.pages = pages;
        this.rating = rating;
        this.id = id;
    }

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

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getFinish() {
        return this.finish;
    }

    public String getPages() {
        return this.pages;
    }

    public String getRating() {
        return this.rating;
    }

    public Integer getId() {
        return id;
    }
}










