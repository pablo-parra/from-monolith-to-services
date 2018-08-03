package pab.par.dom.cart.dataaccess.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Entity to map table Purchase
 *
 */
@Entity
@Table(name = "Purchase")
public class Purchase {

  private static final String SEQ_PURCHASE = "SEQ_PURCHASE";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_PURCHASE)
  @SequenceGenerator(name = SEQ_PURCHASE, sequenceName = "public.SEQ_PURCHASE", allocationSize = 1, initialValue = 1)
  private Long id;

  @Column(name = "article_id")
  private Long articleId;

  private int amount;

  @Column(name = "date_of_purchase")
  private Timestamp dateOfPurchase;

  @Column(name = "user_name")
  private String userName;

  @Transient
  private String instance;

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
   * @return instance
   */
  public String getInstance() {

    return this.instance;
  }

  /**
   * @param instance new value of {@link #getInstance}.
   */
  public void setInstance(String instance) {

    this.instance = instance;
  }

}
