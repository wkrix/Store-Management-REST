package hu.klayton.wade.sm.controller;

import hu.klayton.wade.sm.commons.dto.ProductDTO;
import hu.klayton.wade.sm.commons.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/list_products", method = RequestMethod.GET)
    public String listProducts(final Model model) {
        final List<ProductDTO> productDTOs = productService.findAll();
        model.addAttribute(productDTOs);
        return "product/list_products";
    }

    @RequestMapping(value = "/create_product", method = RequestMethod.GET)
    public String createProduct(final Model model) {
        model.addAttribute(new ProductDTO());
        return "product/product_creator";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createProduct(@ModelAttribute final ProductDTO productDTO, final Errors errors) {
        if (errors.hasErrors()) {
            return "product/product_creator";
        }
        productService.save(productDTO);
        return "redirect:/product/list_products";
    }

    @RequestMapping(value = "/delete/{productId}", method = RequestMethod.GET)
    public String deleteProduct(@PathVariable("productId") final Long id) {
        productService.delete(id);
        return "redirect:/product/list_products";
    }

    @RequestMapping(value = "/modify/{productId}", method = RequestMethod.GET)
    public String modifyProduct(@PathVariable("productId") final Long id, final Model model) {
        final ProductDTO productDTO = productService.findOne(id);
        model.addAttribute(productDTO);
        return "product/product_creator";
    }
}
