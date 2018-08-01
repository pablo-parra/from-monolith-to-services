package pab.par.dom.ecommerce.catalogmanagement.logic.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pab.par.dom.ecommerce.catalogmanagement.dataaccess.repository.ArticleRepository;
import pab.par.dom.ecommerce.catalogmanagement.logic.api.Catalogmanagement;
import pab.par.dom.ecommerce.catalogmanagement.logic.dto.ArticleDto;
import pab.par.dom.ecommerce.catalogmanagement.logic.mapper.ArticleMapper;

/**
 * Impl for the Catalogmanagement interface
 *
 */
@Named
@Transactional
public class CatalogmanagementImpl implements Catalogmanagement {

  @Autowired
  private ArticleRepository articleRepository;

  @Inject
  private ArticleMapper articleMapper;

  @Override
  public List<ArticleDto> getCatalog() {

    return this.articleMapper.toDtos(this.articleRepository.findAll());

  }

}
