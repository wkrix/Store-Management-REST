package hu.klayton.wade.sm.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    private Date validityDate;

    @OneToOne(cascade = CascadeType.REMOVE, mappedBy = "product", orphanRemoval = true)
    private StockMovement stockMovement;

    public Product() {
    }

    public Product(String name, String description, Date creationDate, Date validityDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.validityDate = validityDate;
    }

    public Product(Long id, String name, String description, Date creationDate, Date validityDate) {
        this.id = id;
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

    public StockMovement getStockMovement() {
        return stockMovement;
    }

    public void setStockMovement(StockMovement stockMovement) {
        this.stockMovement = stockMovement;
    }

}
