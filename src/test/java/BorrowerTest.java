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
        library = new Library(5);
        borrower = new Borrower();
    }

    @Test
    public void borrowerHasEmptyBooksList() {
        assertEquals(0, borrower.numOfBooks());
    }

}
