package hu.klayton.wade.sm.dao;

import hu.klayton.wade.sm.domain.WareHouse;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public interface WareHouseRepository extends JpaRepository<WareHouse, Long>{
}
