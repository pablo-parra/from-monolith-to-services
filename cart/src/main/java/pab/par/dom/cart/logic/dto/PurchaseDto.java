package pab.par.dom.cart.logic.dto;

import java.sql.Timestamp;

/**
 * Data Transfer Object for Purchase entity
 *
 */
public class PurchaseDto {

  private Long id;

  private Long articleId;

  private int amount;

  private Timestamp dateOfPurchase;

  private String userName;

  private String origin;

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
  public Timestamp getDateOfPurchase() {

    return this.dateOfPurchase;
  }

  /**
   * @param dateOfPurchase new value of {@link #getDateOfPurchase}.
   */
  public void setDateOfPurchase(Timestamp dateOfPurchase) {

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

  /**
   * @return origin
   */
  public String getOrigin() {

    return this.origin;
  }

  /**
   * @param origin new value of {@link #getOrigin}.
   */
  public void setOrigin(String origin) {

    this.origin = origin;
  }

}
