import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LibraryTest {

    private Library library;
    private Book book;
    private Borrower borrower;

    @Before
    public void before() {
        library = new Library(15);
        book = new Book("The Book Thief", "Markus Zusak", "Novel");
        borrower = new Borrower();
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

    @Test
    public void libraryCantAddMoreBooksThanThereIsCapacity() {
        for (int i = 0; i < 20; i++) {
            library.add(book);
        }
        assertEquals(15, library.numberOfBooks());
    }

    @Test
    public void libraryHasBooksToLend() {
        library.add(book);
        assertTrue(library.hasBooks());
    }

    @Test
    public void libraryDoesntHaveBooksToLend() {
        assertFalse(library.hasBooks());
    }

    @Test
    public void libraryCanLendBookToBorrower() {
        library.add(book);
        library.lend(borrower);
        assertEquals(0, library.numberOfBooks());
        assertEquals(1, borrower.numOfBooks());
    }

    @Test
    public void libraryCanRetrieveBooksFromBorrower() {
        library.add(book);
        library.lend(borrower);
        library.retrieveBooks(borrower);
        assertEquals(1, library.numberOfBooks());
        assertEquals(0, borrower.numOfBooks());
    }

    @Test
    public void libraryHasAnEmptyGenreHashMap() {
        HashMap<String, Integer> test = new HashMap<>();
        assertEquals(0, library.getGenres().size());
        assertEquals(test, library.getGenres());
    }

    @Test
    public void libraryKnowsHowManyBooksOfEachGenreItHasMultipleGenres() {
        library.add(book);
        HashMap<String, Integer> genres = new HashMap<>();
        genres.put("Novel", 1);
        assertEquals(genres, library.getGenres());
        assertEquals(1, library.getGenres().size());
    }

    @Test
    public void libraryKnowsHowManyBooksOfEachGenreItHas() {
        library.add(book);
        library.add(book);
        library.add( new Book("The Very Hungry Caterpillar", "Eric Carle", "Children's Literature"));
        HashMap<String, Integer> genres = new HashMap<>();
        genres.put("Novel", 2);
        genres.put("Children's Literature", 1);
        assertEquals(genres, library.getGenres());
        assertEquals(2, library.getGenres().size());
    }

    @Test
    public void genreHashMapDecrementsWhenABookIsRemoved() {
        library.add(book);
        library.add(book);
        Book newBook = new Book("The Very Hungry Caterpillar", "Eric Carle", "Children's Literature");
        library.add(newBook);
        library.remove(book);
        library.remove(newBook);
        HashMap<String, Integer> genres = new HashMap<>();
        genres.put("Novel", 1);
        assertEquals(genres, library.getGenres());
        assertEquals(1, library.getGenres().size());
    }


}
