package study.englishApp.Exceptions;

public class NotFoundExceptions extends RuntimeException {
    public NotFoundExceptions(String message) {
        super((message));
    }
}