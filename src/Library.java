import java.util.*;

public class Library {
    Map<Long, Book> books = new HashMap<>();
    Map<Long, Book> borrowedBooks = new HashMap<>();
    Map<Long, Reader> readers = new HashMap<>();
    Map<Long, List<BorrowRecord>> borrowHistoryMap = new HashMap<>();

    void addBook(Book book){
        books.put(book.getId(), book);
    }

    void removeBook(Book book){
        if (book.isBorrowed()){
            throw new LibraryException(ErrorCode.BOOK_IS_BORROWED);
        }
        books.remove(book.getId());
    }

    Book findBook(long bookId){
        Book book = books.get(bookId);
        if (Objects.isNull(book)){
            throw new LibraryException(ErrorCode.BOOK_NOT_FOUND);
        }
        return books.get(bookId);
    }

    public List<Book> getAllBooks(){
        return books.values().stream().toList();
    }




    void addReader(Reader reader) {
        readers.put(reader.getId(), reader);
    }

    void removeReader(Reader reader){
        if (!reader.getBorrowedBooks().isEmpty()){
            throw new LibraryException(ErrorCode.READER_HAS_BOOKS);
        }
        readers.remove(reader.getId());
    }

    Reader findReader(long readerId){
        Reader reader = readers.get(readerId);
        if (Objects.isNull(reader)){
            throw new LibraryException(ErrorCode.READER_NOT_FOUND);
        }
        return reader;
    }

    public List<Reader> getAllReaders(){
        return readers.values().stream().toList();
    }



    void borrowBook(long readerId, long bookId){
        Reader reader = findReader(readerId);
        Book book = findBook(bookId);

        if (book.isBorrowed()){
            throw new LibraryException(ErrorCode.BOOK_IS_BORROWED);
        }
        reader.borrowBook(book);
        book.borrow(reader);
    }

    void returnBook(long readerId, long bookId){
        Reader reader = findReader(readerId);
        Book book = findBook(bookId);
//        НАЙТИ КНИГУ И ПОСМОТРЕТЬ ЕСТЬ ЛИ ОНА ИМЕННО У ТОГО РИДЕРА
        reader.returnBook(book);
        book.returnBack();
    }


    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", borrowedBooks=" + borrowedBooks +
                ", readers=" + readers +
                '}';
    }
}
