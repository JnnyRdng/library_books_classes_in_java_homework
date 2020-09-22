import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private ArrayList<Book> booksList;
    private int capacity;
    private HashMap<String, Integer> genres;

    public Library(int capacity) {
        this.booksList = new ArrayList<>();
        this.capacity = capacity;
        this.genres = new HashMap<>();
    }

    public int numberOfBooks() {
        return this.booksList.size();
    }

    public void add(Book book) {
        if (shelfSpace()) {
            this.booksList.add(book);
            this.addGenre(book);
        }
    }

    public void addGenre(Book book) {
        String genre = book.getGenre();
        Integer currentValue = this.genres.get(genre);
        if (currentValue == null) {
            this.genres.put(genre, 1);
        } else {
            Integer newValue = currentValue + 1;
            this.genres.replace(genre, newValue);
        }
    }

    public void removeGenre(Book book) {
        String genre = book.getGenre();
        Integer currentValue = this.genres.get(genre);
        Integer newValue = currentValue - 1;
        if (newValue == 0) {
            this.genres.remove(genre);
        } else {
            this.genres.replace(genre, newValue);
        }
    }

    public HashMap<String, Integer> getGenres() {
        return this.genres;
    }

    public void remove(Book book) {
        this.booksList.remove(book);
        this.removeGenre(book);
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

    public void retrieveBooks(Borrower borrower) {
        while (borrower.hasBooks()) {
            Book returnedBook = borrower.remove();
            this.add(returnedBook);
        }
    }
}
