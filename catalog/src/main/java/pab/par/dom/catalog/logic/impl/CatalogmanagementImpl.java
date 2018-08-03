package pab.par.dom.catalog.logic.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pab.par.dom.catalog.dataaccess.entity.Article;
import pab.par.dom.catalog.dataaccess.repository.ArticleRepository;
import pab.par.dom.catalog.logic.api.Catalogmanagement;
import pab.par.dom.catalog.logic.dto.ArticleDto;
import pab.par.dom.catalog.logic.mapper.ArticleMapper;

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
