package pab.par.dom.catalog.logic.api;

import java.util.List;

import pab.par.dom.catalog.logic.dto.ArticleDto;

/**
 * Interface for the logic layer of the Catalog management
 *
 */
public interface Catalogmanagement {

  List<ArticleDto> getCatalog();

}
