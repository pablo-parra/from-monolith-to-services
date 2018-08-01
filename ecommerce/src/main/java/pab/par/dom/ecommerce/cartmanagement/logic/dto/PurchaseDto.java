package pab.par.dom.ecommerce.cartmanagement.logic.dto;

import java.sql.Date;

/**
 * Data Transfer Object for Purchase entity
 *
 */
public class PurchaseDto {

  private Long id;

  private Long articleId;

  private int amount;

  private Date dateOfPurchase;

  private String userName;

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
   * @return articleId
   */
  public Long getArticleId() {

    return this.articleId;
  }

  /**
   * @param articleId new value of {@link #getArticleId}.
   */
  public void setArticleId(Long articleId) {

    this.articleId = articleId;
  }

  /**
   * @return amount
   */
  public int getAmount() {

    return this.amount;
  }

  /**
   * @param amount new value of {@link #getAmount}.
   */
  public void setAmount(int amount) {

    this.amount = amount;
  }

  /**
   * @return dateOfPurchase
   */
  public Date getDateOfPurchase() {

    return this.dateOfPurchase;
  }

  /**
   * @param dateOfPurchase new value of {@link #getDateOfPurchase}.
   */
  public void setDateOfPurchase(Date dateOfPurchase) {

    this.dateOfPurchase = dateOfPurchase;
  }

  /**
   * @return userName
   */
  public String getUserName() {

    return this.userName;
  }

  /**
   * @param userName new value of {@link #getUserName}.
   */
  public void setUserName(String userName) {

    this.userName = userName;
  }

}
