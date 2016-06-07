package hu.klayton.wade.sm.controller;

import hu.klayton.wade.sm.commons.dto.ProductDTO;
import hu.klayton.wade.sm.commons.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody final ProductDTO productDTO) {
        productService.save(productDTO);
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable("productId") final Long id) {
        productService.delete(id);
    }

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public ProductDTO findProduct(@PathVariable("productId") final Long id) {
        ProductDTO productDTO = productService.findOne(id);

//        NOT NEEDED WITH THAT CLIENT SIDE
//        if (productDTO == null) {
//        throw new SMNotFoundException(id, DomainType.PRODUCT);
//        }
        return productDTO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<ProductDTO> findProducts() {
        List<ProductDTO> productDTOs = productService.findAll();

//        NOT NEEDED WITH THAT CLIENT SIDE
//        if (productDTOs.isEmpty()) {
//            throw new SMNotFoundException(DomainType.PRODUCT);
//        }
        return productDTOs;
    }
}
