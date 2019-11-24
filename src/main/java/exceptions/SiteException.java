package exceptions;

public class SiteException extends RuntimeException {

    public SiteException () {
    }

    public SiteException (String message) {
        super(message);
    }
    public SiteException (String message, Throwable cause) {
        super(message, cause);
    }
    public SiteException (Throwable cause) {
        super(cause);
    }
}
