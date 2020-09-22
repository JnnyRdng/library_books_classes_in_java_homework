import java.util.ArrayList;

public class Library {

    private ArrayList<Book> booksList;

    public Library() {
        this.booksList = new ArrayList<>();
    }

    public int numberOfBooks() {
        return this.booksList.size();
    }

    public void add(Book book) {
        this.booksList.add(book);
    }

    public void remove(Book book) {
        this.booksList.remove(book);
    }
}
