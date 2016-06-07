package hu.klayton.wade.sm.service.impl;

import hu.klayton.wade.sm.commons.dto.WareHouseDTO;
import hu.klayton.wade.sm.commons.service.interfaces.WareHouseService;
import hu.klayton.wade.sm.dao.StockMovementRepository;
import hu.klayton.wade.sm.dao.WareHouseRepository;
import hu.klayton.wade.sm.domain.StockMovement;
import hu.klayton.wade.sm.domain.WareHouse;
import hu.klayton.wade.sm.mapper.WareHouseMapper;
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
public class WareHouseServiceImpl implements WareHouseService {

    @Autowired
    private WareHouseRepository wareHouseRepository;

    @Autowired
    private StockMovementRepository stockMovementRepository;

    @PostConstruct
    private void initDummyData() {
        WareHouse wareHouse = new WareHouse("Budapest's storage", "Small", new Date(), new Date(System.currentTimeMillis() + 1610927890));
        WareHouse wareHouse2 = new WareHouse("Debrecen's storage", "Normal", new Date(), new Date(System.currentTimeMillis() + 1616927896));
        wareHouseRepository.save(wareHouse);
        wareHouseRepository.save(wareHouse2);
    }

    @Override
    public List<WareHouseDTO> findAll() {
        final List<WareHouse> wareHouses = wareHouseRepository.findAll();
        return WareHouseMapper.createListDTO(wareHouses);
    }

    @Override
    public void save(final WareHouseDTO wareHouseDTO) {
        final List<StockMovement> stockMovements = stockMovementRepository.findByWareHouseId(wareHouseDTO.getId());
        WareHouse wareHouse = WareHouseMapper.createEntity(wareHouseDTO);
        wareHouse.setStockMovements(stockMovements);
        if (wareHouse.getCreationDate() == null) {
            wareHouse.setCreationDate(new Date());
        }
        wareHouseRepository.save(wareHouse);
    }

    @Override
    public void delete(final Long id) {
        wareHouseRepository.delete(id);
    }

    @Override
    public WareHouseDTO findOne(Long id) {
        WareHouse wareHouse = wareHouseRepository.findOne(id);
        if (wareHouse == null) {
            return null;
        }
        return WareHouseMapper.createDTO(wareHouse);
    }
}
