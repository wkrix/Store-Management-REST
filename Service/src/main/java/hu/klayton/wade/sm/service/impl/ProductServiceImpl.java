package hu.klayton.wade.sm.service.impl;

import hu.klayton.wade.sm.commons.dto.ProductDTO;
import hu.klayton.wade.sm.commons.service.interfaces.ProductService;
import hu.klayton.wade.sm.dao.ProductRepository;
import hu.klayton.wade.sm.dao.StockMovementRepository;
import hu.klayton.wade.sm.domain.Product;
import hu.klayton.wade.sm.domain.StockMovement;
import hu.klayton.wade.sm.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.hu>
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockMovementRepository stockMovementRepository;


    @PostConstruct
    public void initDummyData() {
        Product product = new Product("Apple", "Fresh", new Date(), new Date(System.currentTimeMillis() + 1616927899));
        Product product2 = new Product("Pear", "Rotten", new Date(), new Date(System.currentTimeMillis() + 1789999899));
        productRepository.save(product);
        productRepository.save(product2);
    }

    @Override
    public List<ProductDTO> findAll() {
        final List<Product> products = productRepository.findAll();
        return ProductMapper.createListDTO(products);
    }

    @Override
    public void save(final ProductDTO productDTO) {
        final StockMovement stockMovement = stockMovementRepository.findByProductId(productDTO.getId());
        final Product product = ProductMapper.createEntity(productDTO);
        product.setStockMovement(stockMovement);
        if (product.getCreationDate() == null) {
            product.setCreationDate(new Date());
        }
        productRepository.save(product);
    }

    @Override
    public void delete(final Long id) {
        productRepository.delete(id);
    }

    @Override
    public ProductDTO findOne(final Long id) {
        Product product = productRepository.findOne(id);
        if (product == null) {
            return null;
        }
        return ProductMapper.createDTO(product);
    }
}
