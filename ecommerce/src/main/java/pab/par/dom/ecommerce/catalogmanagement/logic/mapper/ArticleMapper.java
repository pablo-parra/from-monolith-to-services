package pab.par.dom.ecommerce.catalogmanagement.logic.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import pab.par.dom.ecommerce.catalogmanagement.dataaccess.entity.Article;
import pab.par.dom.ecommerce.catalogmanagement.logic.dto.ArticleDto;

/**
 * Mapper for Article - ArticleDto
 *
 */
@Mapper(componentModel = "spring")
public interface ArticleMapper {

  ArticleDto toDto(Article article);

  List<ArticleDto> toDtos(List<Article> articleList);
}
