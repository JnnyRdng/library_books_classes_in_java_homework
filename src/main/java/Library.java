import java.util.ArrayList;

public class Library {

    private ArrayList<Book> booksList;
    private int capacity;

    public Library(int capacity) {
        this.booksList = new ArrayList<>();
        this.capacity = capacity;
    }

    public int numberOfBooks() {
        return this.booksList.size();
    }

    public void add(Book book) {
        if (shelfSpace()) {
            this.booksList.add(book);
        }
    }

    public void remove(Book book) {
        this.booksList.remove(book);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean shelfSpace() {
        return getCapacity() > numberOfBooks();
    }

    public boolean hasBooks() {
        return numberOfBooks() > 0;
    }

    public void lend(Borrower borrower) {
        if (hasBooks()) {
            Book book = this.booksList.get(0);
            borrower.add(book);
            remove(book);
        }
    }
}
