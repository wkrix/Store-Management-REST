package hu.klayton.wade.sm.dao;

import hu.klayton.wade.sm.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
