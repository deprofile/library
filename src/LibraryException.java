public class LibraryException extends RuntimeException{
    private ErrorCode errorCode;

    public LibraryException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
