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

    public Book remove() {
        return this.books.remove(0);
    }

    public boolean hasBooks() {
        return this.numOfBooks() > 0;
    }
}
