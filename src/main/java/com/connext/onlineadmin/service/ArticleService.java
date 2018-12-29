package com.connext.onlineadmin.service;

import com.connext.onlineadmin.model.Article;

import java.util.List;

public interface ArticleService {
    //查询所有的文章放在列表上
    List<Article> queryAllArticle();
    //查询文章具体内容，包括文章的评论
    Article queryOneArticleDetail(Integer articleId);
    //管理员删除某一篇文章
    void deleteOne(Integer id);
    //根据用户的id删除用户的文章
    void deleteArticleByUserId(Integer id);
}
