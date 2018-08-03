package pab.par.dom.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pab.par.dom.cart.logic.api.Cartmanagement;
import pab.par.dom.cart.logic.dto.PurchaseDto;

/**
 * REST controller for Cart service
 *
 */
@Controller
@RequestMapping("api/v1")
public class CartController {

  @Autowired
  private Cartmanagement cartmanagement;

  /**
   * Saves a list of articles
   *
   * @return the list of all articles of the catalog
   */
  @RequestMapping(value = "/buy", method = RequestMethod.POST)
  public @ResponseBody ResponseEntity<?> buy(@RequestBody List<PurchaseDto> purchases) {

    return new ResponseEntity<>(this.cartmanagement.buy(purchases), HttpStatus.OK);
  }

  /**
   * @return the list of all purchases
   */
  @RequestMapping(value = "/getPurchases", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<?> getPurchases() {

    return new ResponseEntity<>(this.cartmanagement.getPurchases(), HttpStatus.OK);
  }

  /**
   * @return the list of all purchases with article info
   */
  @RequestMapping(value = "/getPurchasesWithArticleInfo", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<?> getPurchasesWithArticlesInfo() {

    return new ResponseEntity<>(this.cartmanagement.getPurchasesWithArticle(), HttpStatus.OK);
  }
}
