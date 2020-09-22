import java.util.ArrayList;

public class Borrower {

    private ArrayList<Book> books;

    public Borrower() {
        this.books = new ArrayList<>();
    }

    public int numOfBooks() {
        return this.books.size();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public void remove(Book book) {
        this.books.remove(book);
    }
}
