public enum ErrorCode  {
    READER_NOT_FOUND("entity.Reader not found", 400),
    BOOK_NOT_FOUND("entity.Book not found", 400),
    BOOK_IS_BORROWED("entity.Book is borrowed", 400),
    BOOK_NOT_BORROWED("entity.Book is not borrowed", 400),
    BOOK_LIMIT("entity.Reader has already have 3 books", 400),
    ALREADY_EXISTS("That subject already exists", 400),
    GLOBAL_ERROR("smth went wrong", 400),
    READER_HAS_BOOKS("READER HAS BOOKS", 400),
    OBJECT_IS_NULL("object is null", 400),
    READER_HAS_NO_BOOKS("entity.Reader has no books", 400);

    private String message;
    private int code;

    ErrorCode(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
