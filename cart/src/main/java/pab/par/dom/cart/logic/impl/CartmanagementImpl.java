package pab.par.dom.cart.logic.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import pab.par.dom.cart.dataaccess.entity.Purchase;
import pab.par.dom.cart.dataaccess.repository.PurchaseRepository;
import pab.par.dom.cart.logic.api.Cartmanagement;
import pab.par.dom.cart.logic.dto.PurchaseDto;
import pab.par.dom.cart.logic.mapper.PurchaseMapper;

/**
 * Implementation of the Cartmanagement interface
 *
 */
@Named
@Transactional
public class CartmanagementImpl implements Cartmanagement {

  @Value("${server.port}")
  private String serverPort;

  @Autowired
  private PurchaseRepository purchaseRepository;

  @Inject
  private PurchaseMapper purchaseMapper;

  @Override
  public List<PurchaseDto> buy(List<PurchaseDto> purchases) {

    purchases.forEach(p -> p.setDateOfPurchase(new Timestamp(new Date().getTime())));
    List<Purchase> savedPurchases = this.purchaseRepository.saveAll(this.purchaseMapper.toEntities(purchases));
    savedPurchases.forEach(sp -> sp.setOrigin(this.serverPort));
    return this.purchaseMapper.toDtos(savedPurchases);
  }

  @Override
  public List<PurchaseDto> getPurchases() {

    List<Purchase> pList = this.purchaseRepository.findAll();
    pList.stream().forEach(p -> p.setOrigin(this.serverPort));
    return this.purchaseMapper.toDtos(pList);
  }

}
