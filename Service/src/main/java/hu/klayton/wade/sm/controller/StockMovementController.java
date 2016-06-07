package hu.klayton.wade.sm.controller;

import hu.klayton.wade.sm.commons.dto.StockMovementDTO;
import hu.klayton.wade.sm.commons.dto.SummaryDTO;
import hu.klayton.wade.sm.commons.service.interfaces.StockMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
@RestController
@RequestMapping("/stockmovements")
public class StockMovementController {

    @Autowired
    private StockMovementService stockMovementService;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStockMovement(@RequestBody final StockMovementDTO stockMovementDTO) {
        stockMovementService.save(stockMovementDTO);
    }

    @RequestMapping(value = "/search/findByWareHouseId", method = RequestMethod.GET)
    public List<SummaryDTO> findByWareHouseId(@RequestParam(value = "id") final Long id) {
        List<SummaryDTO> summaryDTOs = stockMovementService.findByWareHouseId(id);

//        NOT NEEDED WITH THAT CLIENT SIDE
//        if (summaryDTOs.isEmpty()) {
//            throw new SMNotFoundException(DomainType.SUMMARY);
//        }
        return summaryDTOs;
    }

}
