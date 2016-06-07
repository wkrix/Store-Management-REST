package hu.klayton.wade.sm.commons.dto;

import hu.klayton.wade.sm.commons.util.StockMovementType;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public class SummaryDTO {

    private String name;
    private int quantity;
    private StockMovementType type;

    public SummaryDTO() {
    }

    public SummaryDTO(String name, int quantity, StockMovementType type) {
        this.name = name;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StockMovementType getType() {
        return type;
    }

    public void setType(StockMovementType type) {
        this.type = type;
    }
}
