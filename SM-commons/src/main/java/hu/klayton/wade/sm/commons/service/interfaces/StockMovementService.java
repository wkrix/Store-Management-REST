package hu.klayton.wade.sm.commons.service.interfaces;

import hu.klayton.wade.sm.commons.dto.SummaryDTO;
import hu.klayton.wade.sm.commons.dto.StockMovementDTO;

import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.hu>
 */
public interface StockMovementService {

    void save(StockMovementDTO stockMovementDTO);

    List<SummaryDTO> findByWareHouseId(Long id);
}
