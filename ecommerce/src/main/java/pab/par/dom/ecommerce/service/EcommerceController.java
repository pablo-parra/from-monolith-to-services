package pab.par.dom.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pab.par.dom.ecommerce.cartmanagement.logic.api.Cartmanagement;
import pab.par.dom.ecommerce.cartmanagement.logic.dto.PurchaseDto;
import pab.par.dom.ecommerce.catalogmanagement.logic.api.Catalogmanagement;

/**
 * E-commerce REST service controller
 *
 */
@Controller
@RequestMapping("api/v1")
public class EcommerceController {

  @Autowired
  private Catalogmanagement catalogmanagement;

  @Autowired
  private Cartmanagement cartmanagement;

  /**
   * @return the list of all articles of the catalog
   */
  @RequestMapping(value = "/catalog/get", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<?> getCatalog() {

    return new ResponseEntity<>(this.catalogmanagement.getCatalog(), HttpStatus.OK);
  }

  /**
   * Saves a list of articles
   *
   * @return the list of all articles of the catalog
   */
  @RequestMapping(value = "/cart/buy", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<?> buy(@RequestBody List<PurchaseDto> purchases) {

    return new ResponseEntity<>(this.cartmanagement.buy(purchases), HttpStatus.OK);
  }

  /**
   * @return the list of all articles of the catalog
   */
  @RequestMapping(value = "/cart/getPurchases", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<?> getPurchases() {

    return new ResponseEntity<>(this.cartmanagement.getPurchases(), HttpStatus.OK);
  }
}
