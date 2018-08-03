package pab.par.dom.ecommerce.catalogmanagement.logic.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pab.par.dom.ecommerce.catalogmanagement.dataaccess.entity.Article;
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

  @Override
  public ArticleDto getArticle(Long id) {

    ArticleDto articleDto = new ArticleDto();
    Optional<Article> article = this.articleRepository.findById(id);
    if (article.isPresent()) {
      articleDto = this.articleMapper.toDto(article.get());
    }
    return articleDto;
  }

}
