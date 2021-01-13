package mapper;

import domain.Comment;

import java.util.List;

/**
 * 评论类mapper接口
 */
public interface CommentMapper {

    //根据a_id查询评论信息
    public List<Comment> findByAid(Integer a_id);
}
