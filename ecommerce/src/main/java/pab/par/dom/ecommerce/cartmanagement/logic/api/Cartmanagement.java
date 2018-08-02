package pab.par.dom.ecommerce.cartmanagement.logic.api;

import java.util.List;

import pab.par.dom.ecommerce.cartmanagement.logic.dto.PurchaseDto;

/**
 * Interface for logic layer of the cart management
 *
 */
public interface Cartmanagement {

  List<PurchaseDto> buy(List<PurchaseDto> purchases);

  List<PurchaseDto> getPurchases();
}
