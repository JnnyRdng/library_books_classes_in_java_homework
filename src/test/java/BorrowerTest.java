import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BorrowerTest {

    private Book book;
    private Library library;
    private Borrower borrower;

    @Before
    public void before() {
        book = new Book("The Book Thief", "Markus Zusak", "Novel");
        borrower = new Borrower();
    }

    @Test
    public void borrowerHasEmptyBooksList() {
        assertEquals(0, borrower.numOfBooks());
    }

    @Test
    public void borrowerCanAddBookToList() {
        borrower.add(book);
        assertEquals(1, borrower.numOfBooks());
    }

    @Test
    public void borrowerCanRemoveBookFromList() {
        borrower.remove(book);
        assertEquals(0, borrower.numOfBooks());
    }

}
