package pab.par.dom.ecommerce.catalogmanagement.logic.api;

import java.util.List;

import pab.par.dom.ecommerce.catalogmanagement.logic.dto.ArticleDto;

/**
 * Interface for the logic layer of the Catalog management
 *
 */
public interface Catalogmanagement {

  List<ArticleDto> getCatalog();

  ArticleDto getArticle(Long id);

}
