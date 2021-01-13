package test;

import domain.Article;
import domain.Comment;
import mapper.ArticleMapper;
import mapper.CommentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 测试类
 */
public class MyBatisTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }



    /*
        测试查询文章信息及关联的评论信息
     */
    @Test
    public void test1(){
        ArticleMapper mapper = sqlSession.getMapper(ArticleMapper.class);
        List<Article> allWithComment = mapper.findAllWithComment();
        for (Article article : allWithComment) {
            System.out.println(article);
            System.out.println(article.getComments());
        }
    }

    /*
        测试根据a_id查询评论信息
     */
    @Test
    public void test2(){
        CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
        List<Comment> commentList = mapper.findByAid(2);
        for (Comment comment : commentList) {
            System.out.println(comment);
        }
    }



}
