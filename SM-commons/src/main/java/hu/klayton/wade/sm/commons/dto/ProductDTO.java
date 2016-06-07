package hu.klayton.wade.sm.commons.dto;

import java.util.Date;

/**
 * @author Walter Krix <wkrix89@gmail.com>
 */
public class ProductDTO {


    private Long id;

    private String name;

    private String description;

    private Date creationDate;

    private Date validityDate;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Date creationDate, Date validityDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.validityDate = validityDate;
        this.creationDate = creationDate;
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



}
