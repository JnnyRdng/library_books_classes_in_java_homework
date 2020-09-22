import java.util.ArrayList;

public class Library {

    private ArrayList<Book> booksList;

    public Library() {
        this.booksList = new ArrayList<>();
    }

    public int numberOfBooks() {
        return this.booksList.size();
    }
}
