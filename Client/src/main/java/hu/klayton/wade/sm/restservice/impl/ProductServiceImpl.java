package hu.klayton.wade.sm.restservice.impl;

import hu.klayton.wade.sm.commons.dto.ProductDTO;
import hu.klayton.wade.sm.commons.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.hu>
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Environment environment;

    private String url;

    private RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        final String server = environment.getProperty("rest.server.host");
        final String path = environment.getProperty("rest.server.product.path");
        url = server + path;
        restTemplate = new RestTemplate();
    }

    @Override
    public List<ProductDTO> findAll() {
        final ResponseEntity<ProductDTO[]> responseEntity = restTemplate.getForEntity(url, ProductDTO[].class);
        final ProductDTO[] products = responseEntity.getBody();
        return Arrays.asList(products);
    }

    @Override
    public void save(final ProductDTO productDTO) {
        restTemplate.postForEntity(url, productDTO, ProductDTO.class);
    }

    @Override
    public void delete(final Long id) {
        restTemplate.delete(url + id);
    }

    @Override
    public ProductDTO findOne(final Long id) {
        final ResponseEntity<ProductDTO> responseEntity = restTemplate.getForEntity(url + id, ProductDTO.class);
        return responseEntity.getBody();
    }
}
