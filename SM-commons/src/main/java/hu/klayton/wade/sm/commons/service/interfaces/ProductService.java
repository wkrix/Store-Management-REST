package hu.klayton.wade.sm.commons.service.interfaces;

import hu.klayton.wade.sm.commons.dto.ProductDTO;

import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.hu>
 */
public interface ProductService {

    List<ProductDTO> findAll();

    void save(ProductDTO productDTO);

    void delete(Long id);

    ProductDTO findOne(Long id);
}
