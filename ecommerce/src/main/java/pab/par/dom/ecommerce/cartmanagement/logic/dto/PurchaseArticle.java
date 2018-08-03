package pab.par.dom.ecommerce.cartmanagement.logic.dto;

import pab.par.dom.ecommerce.catalogmanagement.logic.dto.ArticleDto;

/**
 * Class to wrapp purchase and article info
 *
 */
public class PurchaseArticle {

  PurchaseDto purchase;

  ArticleDto article;

  /**
   * @return purchase
   */
  public PurchaseDto getPurchase() {

    return this.purchase;
  }

  /**
   * @param purchase new value of {@link #getPurchase}.
   */
  public void setPurchase(PurchaseDto purchase) {

    this.purchase = purchase;
  }

  /**
   * @return article
   */
  public ArticleDto getArticle() {

    return this.article;
  }

  /**
   * @param article new value of {@link #getArticle}.
   */
  public void setArticle(ArticleDto article) {

    this.article = article;
  }

}
