package pab.par.dom.catalog.logic.dto;

import java.math.BigDecimal;

/**
 * Data Transfer Object for Article Entity
 *
 */
public class ArticleDto {

  private Long id;

  private String brand;

  private String model;

  private String description;

  private BigDecimal price;

  /**
   * @return id
   */
  public Long getId() {

    return this.id;
  }

  /**
   * @param id new value of {@link #getId}.
   */
  public void setId(Long id) {

    this.id = id;
  }

  /**
   * @return brand
   */
  public String getBrand() {

    return this.brand;
  }

  /**
   * @param brand new value of {@link #getBrand}.
   */
  public void setBrand(String brand) {

    this.brand = brand;
  }

  /**
   * @return model
   */
  public String getModel() {

    return this.model;
  }

  /**
   * @param model new value of {@link #getModel}.
   */
  public void setModel(String model) {

    this.model = model;
  }

  /**
   * @return description
   */
  public String getDescription() {

    return this.description;
  }

  /**
   * @param description new value of {@link #getDescription}.
   */
  public void setDescription(String description) {

    this.description = description;
  }

  /**
   * @return price
   */
  public BigDecimal getPrice() {

    return this.price;
  }

  /**
   * @param price new value of {@link #getPrice}.
   */
  public void setPrice(BigDecimal price) {

    this.price = price;
  }

}
