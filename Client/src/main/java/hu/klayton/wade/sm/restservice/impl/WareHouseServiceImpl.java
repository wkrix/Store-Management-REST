package hu.klayton.wade.sm.restservice.impl;

import hu.klayton.wade.sm.commons.dto.WareHouseDTO;
import hu.klayton.wade.sm.commons.service.interfaces.WareHouseService;
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
public class WareHouseServiceImpl implements WareHouseService {


    @Autowired
    private Environment environment;

    private String url;

    private RestTemplate restTemplate;


    @PostConstruct
    public void init() {
        String server = environment.getProperty("rest.server.host");
        String path = environment.getProperty("rest.server.warehouse.path");
        url = server + path;
        restTemplate = new RestTemplate();
    }

    @Override
    public List<WareHouseDTO> findAll() {
        final ResponseEntity<WareHouseDTO[]> responseEntity = restTemplate.getForEntity(url, WareHouseDTO[].class);
        final WareHouseDTO[] wareHouses = responseEntity.getBody();
        return Arrays.asList(wareHouses);
    }

    @Override
    public void save(final WareHouseDTO wareHouseDTO) {
        restTemplate.postForEntity(url, wareHouseDTO, WareHouseDTO.class);
    }

    @Override
    public void delete(final Long id) {
        restTemplate.delete(url + id);
    }

    @Override
    public WareHouseDTO findOne(Long id) {
        final ResponseEntity<WareHouseDTO> responseEntity = restTemplate.getForEntity(url + id, WareHouseDTO.class);
        return responseEntity.getBody();
    }
}
