import entity.Author;
import entity.Book;
import entity.Reader;
import repository.BookRepository;
import repository.ReaderBooksRepository;
import repository.ReaderRepository;

void main(){
    BookRepository br = new BookRepository();
    ReaderRepository rr = new ReaderRepository();
    ReaderBooksRepository rbr = new ReaderBooksRepository();

//    rr.save("Adrian", 0);
//    br.save("Stariy Bog", LocalDate.of(1488, 6,7));
    br.getAll();
    rr.getAll();
    rbr.borrowBook(1,1);
}