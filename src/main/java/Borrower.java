import java.util.ArrayList;

public class Borrower {

    private ArrayList<Book> books;

    public Borrower() {
        this.books = new ArrayList<>();
    }

    public int numOfBooks() {
        return this.books.size();
    }
}
