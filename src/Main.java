void main(){
    Library library = new Library();
    Book fightClub = new Book("Fight Club", 1999);
    Book harryPotter = new Book("Harry Potter", 2003);
    Book onePiece = new Book("One Piece", 1984);
    Book robinzonCruzo = new Book("Robinzon Cruzo", 1984);
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
    System.out.println(LibraryUtils.topReader(library));
    System.out.println(LibraryUtils.borrowedBooksCount(library));
    System.out.println(LibraryUtils.mostBorrowedBook(library));
    LibraryUtils.printAllBooks(library);

}