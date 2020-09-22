import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void before() {
        book = new Book("The Book Thief", "Markus Zusak", "Novel");
    }

    @Test
    public void bookHasATitle() {
        assertEquals("The Book Thief", book.getTitle());
    }

    @Test
    public void bookHasAnAuthor() {
        assertEquals("Markus Zusak", book.getAuthor());
    }

    @Test
    public void bookHasAGenre() {
        assertEquals("Novel", book.getGenre());
    }

}
