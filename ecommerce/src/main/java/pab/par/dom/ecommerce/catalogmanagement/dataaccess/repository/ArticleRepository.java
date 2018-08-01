package pab.par.dom.ecommerce.catalogmanagement.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pab.par.dom.ecommerce.catalogmanagement.dataaccess.entity.Article;

/**
 * Spring Data repository for Articles
 *
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
