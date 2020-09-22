import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;
    private Book book;

    @Before
    public void before() {
        library = new Library(15);
        book = new Book("The Book Thief", "Markus Zusak", "Novel");
    }

    @Test
    public void libraryHasACollectionOfBooks() {
        assertEquals(0, library.numberOfBooks());
    }

    @Test
    public void canAddABookToTheLibrary() {
        library.add(book);
        assertEquals(1, library.numberOfBooks());
    }

    @Test
    public void canRemoveABookFromTheLibrary() {
        library.add(book);
        library.remove(book);
        assertEquals(0, library.numberOfBooks());
    }

    @Test
    public void libraryHasACapacity() {
        assertEquals(15, library.getCapacity());
    }

    @Test
    public void libraryHasShelfSpaceRemaining() {
        assertTrue(library.shelfSpace());
    }

    @Test
    public void libraryHasNoShelfSpaceLeft() {
        for (int i = 0; i < 20; i++) {
            library.add(book);
        }
        assertFalse(library.shelfSpace());
    }

}
