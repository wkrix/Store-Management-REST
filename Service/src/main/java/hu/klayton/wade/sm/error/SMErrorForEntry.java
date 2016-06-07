package hu.klayton.wade.sm.error;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public class SMErrorForEntry implements SMError {

    private String id;
    private String message;

    public SMErrorForEntry(SMNotFoundException e) {
        this.id = String.valueOf(e.getId());
        this.message = String.format("%s is not found.", e.getDt());
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
