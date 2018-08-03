package pab.par.dom.ecommerce.cartmanagement.logic.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pab.par.dom.ecommerce.cartmanagement.dataaccess.entity.Purchase;
import pab.par.dom.ecommerce.cartmanagement.dataaccess.repository.PurchaseRepository;
import pab.par.dom.ecommerce.cartmanagement.logic.api.Cartmanagement;
import pab.par.dom.ecommerce.cartmanagement.logic.dto.PurchaseArticle;
import pab.par.dom.ecommerce.cartmanagement.logic.dto.PurchaseDto;
import pab.par.dom.ecommerce.cartmanagement.logic.mapper.PurchaseMapper;
import pab.par.dom.ecommerce.catalogmanagement.logic.api.Catalogmanagement;

/**
 * Implementation of the Cartmanagement interface
 *
 */
@Named
@Transactional
public class CartmanagementImpl implements Cartmanagement {

  @Autowired
  private PurchaseRepository purchaseRepository;

  @Inject
  private PurchaseMapper purchaseMapper;

  @Autowired
  private Catalogmanagement catalogManagement;

  @Override
  public List<PurchaseDto> buy(List<PurchaseDto> purchases) {

    purchases.forEach(p -> p.setDateOfPurchase(new Timestamp(new Date().getTime())));
    return this.purchaseMapper.toDtos(this.purchaseRepository.saveAll(this.purchaseMapper.toEntities(purchases)));
  }

  @Override
  public List<PurchaseDto> getPurchases() {

    return this.purchaseMapper.toDtos(this.purchaseRepository.findAll());
  }

  @Override
  public List<PurchaseArticle> getPurchasesWithArticle() {

    List<PurchaseArticle> purchaseArticleList = new ArrayList<>();

    List<Purchase> purchaseList = this.purchaseRepository.findAll();

    for (Purchase purchase : purchaseList) {
      PurchaseArticle purchaseArticle = new PurchaseArticle();
      purchaseArticle.setPurchase(this.purchaseMapper.toDto(purchase));
      purchaseArticle.setArticle(this.catalogManagement.getArticle(purchase.getArticleId()));
      purchaseArticleList.add(purchaseArticle);
    }
    return purchaseArticleList;
  }

}
