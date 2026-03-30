import java.time.LocalDate;

public class Book {
    private long id;
    private String name;
    private int year;
    private Author author;
    private boolean isBorrowed;
    private Reader borrowedBy;
    private int borrowCount;

    public Book(String name, int year) {
        this.name = name;
        this.year = year;
        this.id = Identifiers.bookId++;
    }

    void borrow(Reader reader){
        if (isBorrowed) {
            throw new LibraryException(ErrorCode.BOOK_IS_BORROWED);
        }

        borrowedBy = reader;
        isBorrowed = true;
        borrowCount++;
    }

    void returnBack(){
        if (!isBorrowed){
            throw new LibraryException(BOOK_NOT_BORROWED);
        }
        isBorrowed = false;
        borrowedBy = null;
    }

    String getInfo(){
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", isBorrowed=" + isBorrowed +
                ", borrowedBy=" + borrowedBy +
                ", borrowCount=" + borrowCount +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public Reader getBorrowedBy() {
        return borrowedBy;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public int getBorrowCount() {
        return borrowCount;
    }


    long getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
