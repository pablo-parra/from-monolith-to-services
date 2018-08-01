package pab.par.dom.ecommerce.cartmanagement.logic.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pab.par.dom.ecommerce.cartmanagement.dataaccess.repository.PurchaseRepository;
import pab.par.dom.ecommerce.cartmanagement.logic.api.Cartmanagement;
import pab.par.dom.ecommerce.cartmanagement.logic.dto.PurchaseDto;
import pab.par.dom.ecommerce.cartmanagement.logic.mapper.PurchaseMapper;

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

  @Override
  public List<PurchaseDto> buy(List<PurchaseDto> purchases) {

    return this.purchaseMapper.toDtos(this.purchaseRepository.saveAll(this.purchaseMapper.toEntities(purchases)));
  }

}
