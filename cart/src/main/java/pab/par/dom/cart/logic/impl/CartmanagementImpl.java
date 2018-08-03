package pab.par.dom.cart.logic.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import pab.par.dom.cart.dataaccess.entity.Purchase;
import pab.par.dom.cart.dataaccess.repository.PurchaseRepository;
import pab.par.dom.cart.logic.api.Cartmanagement;
import pab.par.dom.cart.logic.dto.ArticleInfo;
import pab.par.dom.cart.logic.dto.PurchaseArticle;
import pab.par.dom.cart.logic.dto.PurchaseDto;
import pab.par.dom.cart.logic.mapper.PurchaseMapper;

/**
 * Implementation of the Cartmanagement interface
 *
 */
@Named
@Transactional
public class CartmanagementImpl implements Cartmanagement {

  /**
   * Logger instance.
   */
  private static final Logger LOG = LoggerFactory.getLogger(CartmanagementImpl.class);

  private static final String ARTICLE = "/article/";

  @Value("${server.port}")
  private String serverPort;

  @Value("${catalog.url}")
  private String catalogUrl;

  @Autowired
  private PurchaseRepository purchaseRepository;

  @Inject
  private PurchaseMapper purchaseMapper;

  private final RestTemplate restTemplate;

  public CartmanagementImpl(RestTemplateBuilder restTemplateBuilder) {

    this.restTemplate = restTemplateBuilder.build();
  }

  @Override
  public List<PurchaseDto> buy(List<PurchaseDto> purchases) {

    purchases.forEach(p -> p.setDateOfPurchase(new Timestamp(new Date().getTime())));
    List<Purchase> savedPurchases = this.purchaseRepository.saveAll(this.purchaseMapper.toEntities(purchases));
    savedPurchases.forEach(sp -> sp.setInstance(this.serverPort));
    return this.purchaseMapper.toDtos(savedPurchases);
  }

  @Override
  public List<PurchaseDto> getPurchases() {

    List<Purchase> purchaseList = this.purchaseRepository.findAll();
    purchaseList.stream().forEach(p -> p.setInstance(this.serverPort));
    return this.purchaseMapper.toDtos(purchaseList);
  }

  @Override
  public List<PurchaseArticle> getPurchasesWithArticle() {

    List<PurchaseArticle> purchaseArticleList = new ArrayList<>();
    List<Purchase> purchaseList = this.purchaseRepository.findAll();
    purchaseList.stream().forEach(p -> p.setInstance(this.serverPort));
    this.purchaseMapper.toDtos(purchaseList);

    LOG.info("CATALOG URL: {}", this.catalogUrl);

    for (Purchase purchase : purchaseList) {
      PurchaseArticle purchaseArticle = new PurchaseArticle();
      purchaseArticle.setPurchase(this.purchaseMapper.toDto(purchase));
      purchaseArticle.setArticleInfo(getArticleInfo(purchase.getArticleId()));

      purchaseArticleList.add(purchaseArticle);
    }

    return purchaseArticleList;
  }

  private ArticleInfo getArticleInfo(Long articleId) {

    ArticleInfo articleInfo = new ArticleInfo();
    try {
      String getArticleUrl = this.catalogUrl.concat(ARTICLE).concat(articleId.toString());
      articleInfo = this.restTemplate.getForObject(getArticleUrl, ArticleInfo.class);
    } catch (Exception e) {
      LOG.error("GET ARTICLE ERROR {}", e.getMessage());
    }
    return articleInfo;
  }

}
