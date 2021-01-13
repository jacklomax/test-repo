package mapper;

import domain.Article;

import java.util.List;

/**
 * 文章类mapper接口
 */
public interface ArticleMapper {

    public List<Article> findAllWithComment();
}
