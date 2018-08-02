package pab.par.dom.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pab.par.dom.catalog.logic.api.Catalogmanagement;

/**
 * REST controller for Catalog service
 *
 */
@Controller
@RequestMapping("api/v1")
public class CatalogController {

  @Autowired
  private Catalogmanagement catalogmanagement;

  /**
   * @return the list of all articles of the catalog
   */
  @RequestMapping(value = "/get", method = RequestMethod.GET)
  public @ResponseBody ResponseEntity<?> getDrivers() {

    return new ResponseEntity<>(this.catalogmanagement.getCatalog(), HttpStatus.OK);
  }
}
