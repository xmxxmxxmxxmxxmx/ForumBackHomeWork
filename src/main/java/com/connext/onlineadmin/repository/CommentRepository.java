package com.connext.onlineadmin.repository;



import com.connext.onlineadmin.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment>  findAllByArticle_Id(Integer id);

    //管理员删除用户，同时删除评论
    @Modifying
    @Query(value = "delete from comment where user_id = ?1",nativeQuery = true)
    void deleteCommentsByUserId(Integer id);

    //删除文章同时同时删除文章所有评论
    @Modifying
    @Query(value = "delete from comment where message_id = ?1",nativeQuery = true)
    void deleteCommentsByArticle_Id(Integer id);
}
