package hu.klayton.wade.sm.dao;

import hu.klayton.wade.sm.commons.dto.SummaryDTO;
import hu.klayton.wade.sm.domain.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {

    @Query("SELECT NEW hu.klayton.wade.sm.commons.dto.SummaryDTO(p.name, sm.quantity, sm.type) FROM StockMovement sm INNER JOIN sm.product p INNER JOIN sm.wareHouse wh WHERE wh.id = (:id)")
    List<SummaryDTO> findSummaryDTOByWareHouseId(@Param("id") Long id);

    List<StockMovement> findByWareHouseId(Long id);

    StockMovement findByProductId(Long id);
}
