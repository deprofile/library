import java.util.ArrayList;
import java.util.List;

public class Reader {
    private long id;
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();
    private int totalBooks;

    public Reader( String name) {
        this.name = name;
        this.id = Identifiers.readerId++;
    }

    boolean borrowBook(Book book){
        if (borrowedBooks.size() >= 3 ){
            throw new LibraryException(ErrorCode.BOOK_LIMIT);
        }
        borrowedBooks.add(book);
        totalBooks++;
        return false;
    }

    void returnBook(Book book){
        borrowedBooks.remove(book);
    }

    String getInfo(){
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }

    public long getId() {
        return id;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
