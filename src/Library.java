import entity.Author;
import entity.Book;
import entity.Reader;
import lombok.Locked;
import repository.AuthorRepository;
import repository.BookRepository;
import repository.ReaderBooksRepository;
import repository.ReaderRepository;

import java.time.LocalDate;
import java.util.*;

public class Library {
    private final BookRepository br = new BookRepository();
    private final ReaderRepository rr = new ReaderRepository();
    private final AuthorRepository ar = new AuthorRepository();
    private final ReaderBooksRepository rbr = new ReaderBooksRepository();


    /*Book*/


    void addBook(Book book){
        br.save(book.getTitle(), book.getLocalDate());
    }

    void removeBook(Long id){
        br.remove(id);
    }

    Book findBook(Book book){
        return br.getById(book.getId());
    }

    public void getAllBooks(){
        br.getAll();
    }


    /*Book*/

    /*Reader*/


    void addReader(Reader reader) {
        rr.save(reader.getName(), reader.getTotalBooks());
    }

    void removeReader(Reader reader){
        rr.remove(reader.getId());
    }

    Reader findReader(Reader reader){
        return rr.getById(reader.getId());
    }

    void getAllReaders(){
        rr.getAll();
    }


    /*Reader*/

    /*Author*/

    void addAuthor(Author author){
        ar.save(author.getName());
    }

    void removeAuthor(Long id){
        br.remove(id);
    }

    Book findAuthor(Book book){
        return br.getById(book.getId());
    }

    public void getAllAuthor(){
        br.getAll();
    }

    /*Author*/


    public void borrowBook(long readerId, long bookId){

        rbr.borrowBook(readerId, bookId);
    }

    void returnBook(long readerId, long bookId){
        // сверху
    }

    public void getAuthorBookMap() {
        //
    }

    void getBorrowHistoryByRange(LocalDate startDate, LocalDate endDate){
        //
    }
}
