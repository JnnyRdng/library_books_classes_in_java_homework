import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book;

    @Before
    public void before() {
        library = new Library();
        book = new Book("The Book Thief", "Markus Zusak", "Novel");
    }

    @Test
    public void libraryHasACollectionOfBooks() {
        assertEquals(0, library.numberOfBooks());
    }

}
