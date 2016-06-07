package hu.klayton.wade.sm.error;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public class SMErrorForCollection implements SMError {

    private String message;

    public SMErrorForCollection(SMNotFoundException e) {
        this.message = String.format("%s are not found. The collection is empty.", e.getDt());
    }

    public String getMessage() {
        return message;
    }
}
