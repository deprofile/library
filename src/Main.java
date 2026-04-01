void main(){
    Library library = new Library();
    Author author1 = new Author("Stepan Gladkiy", 17);
    Book fightClub = new Book("Fight Club", 1999, author1);
    Book harryPotter = new Book("Harry Potter", 2003, author1);
    Book onePiece = new Book("One Piece", 1984, author1);
    Book robinzonCruzo = new Book("Robinzon Cruzo", 1984, author1);
    Reader John = new Reader("John");
    Reader Billy = new Reader("Billy");

    library.addBook(fightClub);
    library.addBook(harryPotter);
    library.addBook(onePiece);
    library.addBook(robinzonCruzo);

    library.addReader(John);
    library.addReader(Billy);

    library.borrowBook(1, 3);
    library.borrowBook(1, 2);
    library.returnBook(1, 3);
    System.out.println(John.getBorrowedBooks());

    library.borrowBook(2, 1);
    library.borrowBook(2, 4);
    System.out.println(library.findReader(1));
    System.out.println(LibraryUtils.mostBorrowedBook(library));
    System.out.println(LibraryUtils.allBooksFromReader(library, 2));
    System.out.println(LibraryUtils.allBooksFromAuthor(library, 1));

    System.out.println(library.getAllBooks());
    System.out.println(library.getAuthorBookMap());
    System.out.println(LibraryUtils.topReader(library));
}