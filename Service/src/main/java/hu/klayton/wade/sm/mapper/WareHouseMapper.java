package hu.klayton.wade.sm.mapper;

import hu.klayton.wade.sm.commons.dto.WareHouseDTO;
import hu.klayton.wade.sm.domain.WareHouse;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public final class WareHouseMapper {

    private WareHouseMapper() {
    }

    public static WareHouse createEntity(WareHouseDTO wareHouseDTO) {
        return new WareHouse(wareHouseDTO.getId(), wareHouseDTO.getName(), wareHouseDTO.getDescription(), wareHouseDTO.getCreationDate(), wareHouseDTO.getValidityDate());
    }

    public static WareHouseDTO createDTO(WareHouse wareHouse) {
        return new WareHouseDTO(wareHouse.getId(), wareHouse.getName(), wareHouse.getDescription(), wareHouse.getCreationDate(), wareHouse.getValidityDate());
    }

    public static List<WareHouseDTO> createListDTO(List<WareHouse> wareHouses) {
        final List<WareHouseDTO> wareHouseDTOs = new ArrayList<>();
        for (WareHouse wareHouse : wareHouses) {
            wareHouseDTOs.add(createDTO(wareHouse));
        }
        return wareHouseDTOs;
    }
}
