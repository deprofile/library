import entity.Book;
import entity.Reader;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class LibraryUtils {

//    public List<Reader> getTopThreeReaders (Library lib){
//        return lib.getAllReaders().stream()
//                        .sorted(Comparator
//                                .comparing(Reader::getTotalBooks)
//                                .reversed())
//                        .limit(3)
//                        .toList();
//    }
//
//    public List<Book> getTopThreeBooks(Library lib){
//        return null;
//    }
//
////    static int totalBooks(Library lib){
////        return lib.getAllBooks().size();
////    }
//
//    static Optional<Reader> topReader(Library lib){
//        if (lib.readers.isEmpty()) {
//            throw new LibraryException(ErrorCode.OBJECT_IS_NULL);
//        }
//
//        return lib.getAllReaders().stream().max(Comparator.comparing(Reader::getTotalBooks));
//    }
//
//    static Optional<Book> mostBorrowedBook(Library lib){
//        return null;
//    }
//
//    static List<Book> allAvailableBooks (Library lib){
//        return null;
//    }
//
//    static List<Book> allBooksFromReader (Library lib, long readerId){
//        Reader reader = lib.readers.get(readerId);
//        return reader.getBorrowedBooks();
//    }
//
//    static List<Book> allBooksFromAuthor (Library lib, long authorId){
//        return lib.authorBookMap.get(authorId);
//    }
//
//
//    static void printBookInfo(Book book){
//        System.out.println("book.getInfo()");
//    }
//
//    static void printAllBooks(Library lib){
//        lib.getAllBooks();
//    }
}
