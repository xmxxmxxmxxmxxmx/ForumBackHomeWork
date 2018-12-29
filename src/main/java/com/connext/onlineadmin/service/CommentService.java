package com.connext.onlineadmin.service;



import com.connext.onlineadmin.model.Comment;

import java.util.List;

public interface CommentService {
    //根据文章id查询文章有关评论
    List<Comment> queryCommentByArticleId(Integer id);
    //管理员删除文章某一个的评论
    void deleteOneComment(Integer id);
    //管理员删除用户，同时删除评论
    void deleteCommentByUserId(Integer id);
    //删除文章时同时删除评论
    void deleteCommentByArticleId(Integer id);
}
