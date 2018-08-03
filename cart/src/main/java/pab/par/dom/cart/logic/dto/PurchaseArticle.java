package pab.par.dom.cart.logic.dto;

/**
 * Class to wrapp purchase and article info
 *
 */
public class PurchaseArticle {

  PurchaseDto purchase;

  ArticleInfo articleInfo;

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
   * @return articleInfo
   */
  public ArticleInfo getArticleInfo() {

    return this.articleInfo;
  }

  /**
   * @param articleInfo new value of {@link #getArticleInfo}.
   */
  public void setArticleInfo(ArticleInfo articleInfo) {

    this.articleInfo = articleInfo;
  }

}
