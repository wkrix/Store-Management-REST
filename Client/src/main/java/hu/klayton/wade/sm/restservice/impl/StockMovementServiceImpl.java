package hu.klayton.wade.sm.restservice.impl;

import hu.klayton.wade.sm.commons.dto.StockMovementDTO;
import hu.klayton.wade.sm.commons.dto.SummaryDTO;
import hu.klayton.wade.sm.commons.service.interfaces.StockMovementService;
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
public class StockMovementServiceImpl implements StockMovementService {

    @Autowired
    private Environment environment;

    private String url;

    private RestTemplate restTemplate;


    @PostConstruct
    public void init() {
        final String server = environment.getProperty("rest.server.host");
        final String path = environment.getProperty("rest.server.stockmovement.path");
        url = server + path;
        restTemplate = new RestTemplate();
    }

    @Override
    public void save(StockMovementDTO stockMovementDTO) {
        restTemplate.postForEntity(url, stockMovementDTO, StockMovementDTO.class);
    }

    @Override
    public List<SummaryDTO> findByWareHouseId(Long id) {
        final String uri = "search/findByWareHouseId?id={id}";
        final ResponseEntity<SummaryDTO[]> responseEntity = restTemplate.getForEntity(url + uri, SummaryDTO[].class, id);
        return Arrays.asList(responseEntity.getBody());
    }
}
