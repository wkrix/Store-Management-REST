package hu.klayton.wade.sm.controller;

import hu.klayton.wade.sm.commons.dto.WareHouseDTO;
import hu.klayton.wade.sm.commons.service.interfaces.WareHouseService;
import hu.klayton.wade.sm.commons.util.DomainType;
import hu.klayton.wade.sm.error.SMNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
@RestController
@RequestMapping("/warehouses")
public class WareHouseController {

    @Autowired
    private WareHouseService wareHouseService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveWareHouse(@RequestBody final WareHouseDTO wareHouseDTO) {
        wareHouseService.save(wareHouseDTO);
    }

    @RequestMapping(value = "/{wareHouseId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWareHouse(@PathVariable("wareHouseId") final Long id) {
        wareHouseService.delete(id);
    }

    @RequestMapping(value = "/{wareHouseId}", method = RequestMethod.GET)
    public WareHouseDTO findWareHouse(@PathVariable("wareHouseId") final Long id) {
        WareHouseDTO wareHouseDTO = wareHouseService.findOne(id);

//        NOT NEEDED WITH THAT CLIENT SIDE
//        if (wareHouseDTO == null) {
//            throw new SMNotFoundException(id, DomainType.WAREHOUSE);
//        }
        return wareHouseDTO;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<WareHouseDTO> findWareHouses() {
        List<WareHouseDTO> wareHouseDTOs = wareHouseService.findAll();

//        NOT NEEDED WITH THAT CLIENT SIDE
//        if (wareHouseDTOs.isEmpty()) {
//            throw new SMNotFoundException(DomainType.WAREHOUSE);
//        }
        return wareHouseDTOs;
    }
}
