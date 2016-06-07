package hu.klayton.wade.sm.mapper;

import hu.klayton.wade.sm.commons.dto.StockMovementDTO;
import hu.klayton.wade.sm.domain.StockMovement;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public final class StockMovementMapper {

    private StockMovementMapper() {
    }

    public static StockMovement createEntity(StockMovementDTO stockMovementDTO) {
        return new StockMovement(stockMovementDTO.getId(), stockMovementDTO.getDescription(), stockMovementDTO.getQuantity(), stockMovementDTO.getType());
    }
}
