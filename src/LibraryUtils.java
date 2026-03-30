import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class LibraryUtils {
    public List<Reader> getTopThreeReaders (Library lib){
        return lib.getAllReaders().stream()
                        .sorted(Comparator
                                .comparing(Reader::getTotalBooks)
                                .reversed())
                        .limit(3)
                        .toList();
    }
    static int totalBooks(Library lib){
        return lib.getAllBooks().size();
    }

    static Reader topReader(Library lib){
        Reader maxReader = lib.readers.get(0);
        for (int i = 0; i < lib.getAllReaders().size(); i++) {
            if (lib.readers.get(i).getBorrowedBooks().size() > maxReader.getBorrowedBooks().size()){
                maxReader = lib.readers.get(i);
            }
        }
        return maxReader;
    }

    static Optional<Book> mostBorrowedBook(Library lib){
        return lib.getAllBooks().stream().max(Comparator.comparing(Book::getBorrowCount));
    }

    static void printBookInfo(Book book){
        System.out.println(book.getInfo());
    }

    static void printAllBooks(Library lib){
        System.out.println(lib.getAllBooks());
    }
}
