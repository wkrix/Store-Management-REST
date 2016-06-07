package hu.klayton.wade.sm.mapper;

import hu.klayton.wade.sm.commons.dto.ProductDTO;
import hu.klayton.wade.sm.domain.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public final class ProductMapper {

    private ProductMapper() {
    }

    public static Product createEntity(ProductDTO productDTO) {
        return new Product(productDTO.getId(), productDTO.getName(), productDTO.getDescription(), productDTO.getCreationDate(), productDTO.getValidityDate());
    }

    public static ProductDTO createDTO(Product product) {
        return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getCreationDate(), product.getValidityDate());
    }

    public static List<ProductDTO> createListDTO(List<Product> products) {
        final List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            productDTOs.add(createDTO(product));
        }
        return productDTOs;
    }
}
