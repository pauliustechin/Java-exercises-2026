package psem.supermarket.exception;

public class NotEnoughChangeException extends Exception {

    public NotEnoughChangeException() {
    }

    public NotEnoughChangeException(String message) {
        super(message);
    }
}
