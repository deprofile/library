import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    Map<Long, Book> books = new HashMap<>();
    Map<Long, Reader> readers = new HashMap<>();
    NavigableMap<LocalDate, List<BorrowRecord>> borrowHistoryMap = new TreeMap<>();
    Map<Long, List<Book>> authorBookMap = new HashMap<>();

    void addBook(Book book){
        books.put(book.getId(), book);
        authorBookMap.computeIfAbsent(book.getAuthor().getId(), _ -> new ArrayList<>()).add(book);
    }

    void removeBook(Book book){
        if (book.isBorrowed()){
            throw new LibraryException(ErrorCode.BOOK_IS_BORROWED);
        }
        books.remove(book.getId());
        authorBookMap.get(book.getAuthor().getId()).removeIf(el -> el.equals(book));
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

    public Map<Long, List<Book>> getAuthorBookMap() {
        return authorBookMap;
    }

    List<BorrowRecord> getBorrowHistoryByRange(LocalDate startDate, LocalDate endDate){
        if (startDate.isAfter(endDate)){
            throw new LibraryException(ErrorCode.GLOBAL_ERROR);
        }
        return borrowHistoryMap.subMap(startDate, true, endDate, true)
                .values()
                .stream()
                .flatMap(el -> el.stream())
                .toList();
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", readers=" + readers +
                '}';
    }
}
