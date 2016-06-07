package hu.klayton.wade.sm.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
@Entity
@Table(name = "Ware_Houses")
public class WareHouse {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    private Date validityDate;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "wareHouse", orphanRemoval = true)
    private List<StockMovement> stockMovements;

    public WareHouse() {
    }

    public WareHouse(Long id, String name, String description, Date creationDate, Date validityDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.validityDate = validityDate;
    }

    public WareHouse(String name, String description, Date creationDate, Date validityDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.validityDate = validityDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public List<StockMovement> getStockMovements() {
        return stockMovements;
    }

    public void setStockMovements(List<StockMovement> stockMovements) {
        this.stockMovements = stockMovements;
    }

    public void addStockMovement(StockMovement stockMovement) {
        if (this.stockMovements == null) {
            this.stockMovements = new ArrayList<>();
        }
        this.stockMovements.add(stockMovement);
    }
}
