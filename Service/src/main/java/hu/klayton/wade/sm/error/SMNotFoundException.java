package hu.klayton.wade.sm.error;


import hu.klayton.wade.sm.commons.util.DomainType;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public class SMNotFoundException extends RuntimeException {

    private Long id;
    private DomainType dt;


    public SMNotFoundException(DomainType dt) {
        this.dt = dt;
    }

    public SMNotFoundException(Long id, DomainType dt) {
        this.id = id;
        this.dt = dt;
    }

    public Long getId() {
        return id;
    }

    public DomainType getDt() {
        return dt;
    }
}
