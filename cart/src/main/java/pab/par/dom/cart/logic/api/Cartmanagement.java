package pab.par.dom.cart.logic.api;

import java.util.List;

import pab.par.dom.cart.logic.dto.PurchaseArticle;
import pab.par.dom.cart.logic.dto.PurchaseDto;

/**
 * Interface for logic layer of the cart management
 *
 */
public interface Cartmanagement {

  List<PurchaseDto> buy(List<PurchaseDto> purchases);

  List<PurchaseDto> getPurchases();

  List<PurchaseArticle> getPurchasesWithArticle();
}
